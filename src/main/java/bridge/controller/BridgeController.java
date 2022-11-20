package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;
    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }
    public void setBridgeController() {
        int size = inputView.readBridgeSize();
        bridgeGame.setBridge(size);
    }
    public void moveController() {
        String move = inputView.readMoving();
        bridgeGame.move(move);
    }
    public void retryController() {}
    public void startController() {
        outputView.printStart();
    }
    public void printMapController() {}
    public void printResultController() {}
}
