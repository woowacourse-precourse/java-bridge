package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;

public class BridgeGameService {

    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public Bridge createBridge(int bridgeSize) {
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
