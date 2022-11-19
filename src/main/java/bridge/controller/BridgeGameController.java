package bridge.controller;

import bridge.domain.BridgeGame;
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
        while (true) {
            String moveLocation = getMove();
            bridgeGame.move(moveLocation);
            outputView.printMap(bridgeGame.getResult());
            bridgeGame.updateGameStatus(moveLocation);
        }
    }
}