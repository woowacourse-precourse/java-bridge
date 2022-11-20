package bridge.controller;

import bridge.domain.SizeOfBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        set();
    }

    public void set() {
        SizeOfBridge sizeOfBridge = InputView.readBridgeSize();
    }

}
