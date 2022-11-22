package bridge.service;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;

import java.util.List;

public class BridgeService {
    private final BridgeMaker bridgeMaker;

    public BridgeService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }
    public Bridge makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(size, bridge);
    }
}
