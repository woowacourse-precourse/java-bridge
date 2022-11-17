package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;

public class BridgeMakerService {

    public static Bridge createBridge() {
        BridgeMaker bridgeMaker = createBridgeMaker();
        return new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
    }

    private static BridgeMaker createBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
