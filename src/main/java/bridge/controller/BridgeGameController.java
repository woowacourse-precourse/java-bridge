package bridge.controller;

import bridge.view.InputView;

public class BridgeGameController {

    private final InputView inputView;

    public BridgeGameController() {
        this.inputView = new InputView();
    }

    public void run() {
        inputView.printStartMessage();
    }
}
