package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void setBridgeController() {
        inputView.readBridgeSize();
    }
    public void moveController() {}
    public void retryController() {}
    public void startController() {
        outputView.printStart();
    }
    public void printMapController() {}
    public void printResultController() {}
}
