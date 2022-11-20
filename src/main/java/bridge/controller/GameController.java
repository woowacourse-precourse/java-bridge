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

    public void play() {
        outputView.printGameStartMessage();
        BridgeSize bridgeSize = readBridgeSize();
        Integer size = bridgeSize.getBrideSize();
        BridgeMaker bridgeMaker = bridgeMaker();
        List<String> bridge = bridgeMaker.makeBridge(size);
        AttemptNumber attemptNumber = attemptNumber();
        BridgeGame bridgeGame = bridgeGame();
        startWalk(bridgeGame, bridge, attemptNumber);
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
        bridgeGame.gameSuccess();
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge, AttemptNumber attemptNumber) {
        while (!bridgeGame.isSuccess()) {
            walk(bridgeGame, bridge);
            if (isRetry(bridgeGame)) {
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
        boolean gameSuccessOrNot = bridgeGame.isSuccess();
        attemptNumber.printAttemptNumber(outputView, gameSuccessOrNot);
    }

    private void printBridge(BridgeGame bridgeGame) {
        List<String> lowBridge = bridgeGame.getLowBridge();
        List<String> highBridge = bridgeGame.getHighBridge();
        outputView.printMap(lowBridge, highBridge);
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus) {
        String moving = moving();
        boolean movePossible = bridgeGame.move(moving, bridgeStatus);
        printBridge(bridgeGame);
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

    private boolean gameCommand() {
        String command = inputView.readGameCommand();
        GameCommand gameCommand = new GameCommand(command);
        return gameCommand.isRetry();
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        while (!bridgeGame.isSuccess()) {
            try {
                return gameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return false;
    }
}