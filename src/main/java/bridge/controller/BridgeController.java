package bridge.controller;

import bridge.Bridge;
import bridge.InputView;
import bridge.OutputView;

public class BridgeController {
    private int bridgeLength;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        outputView.printStart();
        Bridge bridge = new Bridge(inputView.readBridgeSize());

    }
}
