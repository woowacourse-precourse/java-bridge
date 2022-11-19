package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeNumberGenerator;
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

        startWalk(bridgeGame, bridge);
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

    private void walk(BridgeGame bridgeGame, List<String> bridge) {
        for (String bridgeStatus : bridge) {
            if (isMovePossible(bridgeGame, bridgeStatus)) {
                continue;
            }
            return;
        }
        success = true;
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge) {
        AttemptNumber attemptNumber = attemptNumber(); // 리팩토링 대상
        while (!success) {
            walk(bridgeGame, bridge);
            if (isRetry()) {
                bridgeGame.retry(attemptNumber);
                continue;
            }
            break;
        }
        finalGameResult(bridgeGame, attemptNumber);
    }

    private void finalGameResult(BridgeGame bridgeGame, AttemptNumber attemptNumber) {
        outputView.printFinalGameResult();
        printBridge(bridgeGame);
        attemptNumber.printAttemptNumber(outputView, success);
    }

    private void printBridge(BridgeGame bridgeGame) {
        List<String> lowBridge = bridgeGame.getLowBridge();
        List<String> highBridge = bridgeGame.getHighBridge();
        outputView.printMap(lowBridge, highBridge);
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus) {
        String moving = moving();
        boolean move = bridgeGame.move(moving, bridgeStatus);
        printBridge(bridgeGame);
        return move;
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

    private boolean gameCommand() {
        String command = inputView.readGameCommand();
        GameCommand gameCommand = new GameCommand(command);
        return gameCommand.isRetry();
    }

    private boolean isRetry() {
        while (!success) {
            try {
                return gameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return false;
    }
}