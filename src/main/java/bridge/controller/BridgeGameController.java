package bridge.controller;

import bridge.view.InputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();

    public void start() {
        int bridgeSize = inputView.printStartMessage();
    }
}
