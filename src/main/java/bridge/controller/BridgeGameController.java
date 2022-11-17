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
}