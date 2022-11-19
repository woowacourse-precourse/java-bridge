package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printStart();
        BridgeSize bridgeSize = new BridgeSize(inputView.readBridgeSize());
    }
}
