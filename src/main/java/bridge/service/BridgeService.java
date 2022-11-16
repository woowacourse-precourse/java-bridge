package bridge.service;

import bridge.domain.Bridge;
import bridge.util.BridgeMaker;

public class BridgeService {
    private final BridgeMaker bridgeMaker;

    public BridgeService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }
}
