package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

public class BridgeMakerService {

    public static Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = createBridgeMaker();
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private static BridgeMaker createBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
