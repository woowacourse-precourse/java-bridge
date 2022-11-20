package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.PassingSpace;
import bridge.view.OutputView;

import java.util.List;

public class CreatingController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();

    public Bridge createBridge() {
        try {
            int bridgeSize = inputController.inputBridgeSize();
            Bridge bridge = makeBridge(bridgeSize);
            return bridge;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printExceptionMessage(illegalArgumentException);
            return createBridge();
        }
    }

    private Bridge makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeProtoType = bridgeMaker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(bridgeProtoType);
        return bridge;
    }

    public BridgeGame createBridgeGame(Bridge bridge) {
        PassingSpace passingSpace = new PassingSpace();
        return new BridgeGame(bridge, passingSpace);
    }
}