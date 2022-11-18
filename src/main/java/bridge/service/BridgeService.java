package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;

public class BridgeService {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;

    public BridgeService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void createBridge(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
