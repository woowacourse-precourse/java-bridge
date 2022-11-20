package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.SizeOfBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView;
    public Bridge bridge;

    public BridgeGameController() {
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        set();
    }

    public void set() {
        SizeOfBridge sizeOfBridge = InputView.readBridgeSize();
        this.bridge = generateBridge(sizeOfBridge);
    }

    private Bridge generateBridge(SizeOfBridge sizeOfBridge) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return new Bridge(bridgeMaker.makeBridge(sizeOfBridge.getSize()));
    }

}
