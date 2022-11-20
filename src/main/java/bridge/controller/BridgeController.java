package bridge.controller;

import bridge.view.OutputView;

public class BridgeController {
    private OutputView outputView;
    public BridgeController() {
        outputView = new OutputView();
    }
    public void setBridgeController() {}
    public void moveController() {}
    public void retryController() {}
    public void startController() {
        outputView.printStart();
    }
    public void printMapController() {}
    public void printResultController() {}
}
