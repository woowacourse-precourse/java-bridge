package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView;
    InputView inputView;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    public void startGame() {
        outputView.printStartGame();
        int bridgeSize = getBridgeSize();
        bridgeGame.createBridge(bridgeSize);
        tryMove();
        outputView.printMap(bridgeGame.getResult());
    }

    public int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }

    public String getMove() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }

    public void tryMove() {
        while (bridgeGame.canPlay()) {
            String moveLocation = getMove();
            bridgeGame.move(moveLocation);
            bridgeGame.updateGameStatus(moveLocation);
            checkRetry();
        }
    }

    private void checkRetry() {
        if (bridgeGame.checkStatus() == Status.SUCCESS.getMessage()) {
            return;
        }
        outputView.printMap(bridgeGame.getResult());
        if (bridgeGame.canPlay()) {
            return;
        }
        if (getRetryCommand().equals("R")) {
            bridgeGame.retry();
        }
    }

    private String getRetryCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }
}