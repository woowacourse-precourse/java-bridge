package bridge;

import bridge.domain.Bridge;

import java.util.List;

public class BridgeBroker {
    private final BridgeMaker bridgeMaker;

    BridgeBroker() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    BridgeBroker(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int size) {
        List<String> bridge = reqeustBridge(size);
        return packageBridge(bridge);
    }

    private List<String> reqeustBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }

    private Bridge packageBridge(List<String> bridge) {
        return new Bridge(bridge);
    }
}
