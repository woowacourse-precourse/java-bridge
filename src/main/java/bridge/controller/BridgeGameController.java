package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void startNewGame() {
        outputView.printStart();
    }

    public void createNewBridge() {
        int bridgeLength = inputView.readBridgeSize();
        bridgeGame.newBridge(bridgeLength);
    }

    public void playTurn() {

    }
}
