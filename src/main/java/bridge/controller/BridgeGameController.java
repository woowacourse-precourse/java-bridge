package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final boolean INPUT_STATUS = true;
    private static final String RETRY = "R";

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
        outputView.printResult(bridgeGame.getResult(), bridgeGame.isSuccess(),
                bridgeGame.getTryCount());
    }

    public int getBridgeSize() {
        while (INPUT_STATUS) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }

    public String getMove() {
        while (INPUT_STATUS) {
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
        outputView.printMap(bridgeGame.getResult());
        if (bridgeGame.checkStatus() == Status.SUCCESS.getMessage()) {
            return;
        }
        if (bridgeGame.canPlay()) {
            return;
        }
        if (getRetryCommand().equals(RETRY)) {
            bridgeGame.retry();
        }
    }

    private String getRetryCommand() {
        while (INPUT_STATUS) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException iae) {
                outputView.printError(iae.getMessage());
            }
        }
    }
}