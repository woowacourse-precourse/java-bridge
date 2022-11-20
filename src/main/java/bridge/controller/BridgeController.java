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
            Bridge bridge = makeBridge(bridgeSize);
            return bridge;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return createBridge();
        }
    }

    private Bridge makeBridge(int bridgeSize) {
        List<String> bridgeProtoType = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(bridgeProtoType);
        return bridge;
    }

    private int inputBridgeSize() {
        outputView.printRequestBridgeSizeInput();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }
}
