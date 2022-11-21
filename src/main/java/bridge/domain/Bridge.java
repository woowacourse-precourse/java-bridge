package bridge.model;

import bridge.domain.BridgeMaker;

import java.util.List;

public class Bridge {

    private final BridgeMaker bridgeMaker;

    public Bridge(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    private static List<String> bridge;

    public void setBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
