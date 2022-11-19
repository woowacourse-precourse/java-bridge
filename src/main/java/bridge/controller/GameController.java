package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeNumberGenerator;
import bridge.MoveResult;
import bridge.model.AttemptNumber;
import bridge.model.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private boolean success = false;

    public void play() {
        outputView.printGameStartMessage();
        BridgeSize bridgeSize = readBridgeSize();

        Integer size = bridgeSize.getBrideSize();

        BridgeMaker bridgeMaker = bridgeMaker();

        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        MoveResult moveResult = moveResult();

        startWalk(bridgeGame, bridge, moveResult);
    }

    private AttemptNumber attemptNumber() {
        return new AttemptNumber();
    }

    private BridgeSize readBridgeSize() {
        while (true) {
            try {
                Integer size = inputView.readBridgeSize();
                return new BridgeSize(size);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private BridgeMaker bridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

    private void walk(BridgeGame bridgeGame, List<String> bridge, MoveResult moveResult) {
        for (String bridgeStatus : bridge) {
            if (isMovePossible(bridgeGame, bridgeStatus, moveResult)) {
                moveResult.printBridge(outputView);
                continue;
            }
            moveResult.printBridge(outputView);
            return;
        }
        success = true;
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge, MoveResult moveResult) {
        AttemptNumber attemptNumber = attemptNumber(); // 리팩토링 대상
        while (!isSuccess()) {
            walk(bridgeGame, bridge, moveResult);
            if (isRetry()) {
                bridgeGame.retry(attemptNumber);
                moveResult.clearHistory();
                continue;
            }
            break;
        }
        System.out.println("최종 게임 결과");
        moveResult.printBridge(outputView);
        attemptNumber.printAttemptNumber(outputView, isSuccess());
    }

    private MoveResult moveResult() {
        return new MoveResult();
    }

    private boolean isSuccess() {
        return success;
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus, MoveResult moveResult) {
        String moving = moving();
        boolean movePossible = bridgeGame.move(moving, bridgeStatus);
        moveResult.makeResultBridge(moving, movePossible);

        return movePossible;
    }

    private String moving() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                return new Moving(moving).getMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private boolean isRetry() {
        if (isSuccess()) {
            return false;
        }
        while (true) {
            try {
                String command = inputView.readGameCommand();
                GameCommand gameCommand = new GameCommand(command);
                return gameCommand.isRetry();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}