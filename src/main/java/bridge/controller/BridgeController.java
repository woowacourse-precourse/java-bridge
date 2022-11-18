package bridge.controller;

import bridge.view.InputView;

public class BridgeController {

    InputView inputView = new InputView();

    public void start() {
        inputView.readBridgeSize();
    }

}
