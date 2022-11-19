package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge createBridge() {
        try {
            int bridgeSize = inputBridgeSize();
            List<String> bridgeProtoType = bridgeMaker.makeBridge(bridgeSize);
            Bridge bridge = new Bridge(bridgeProtoType);
            return bridge;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return createBridge();
        }
    }

    private int inputBridgeSize() {
        outputView.printRequestBridgeSizeInput();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }
}
