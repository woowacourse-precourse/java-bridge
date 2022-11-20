package bridge.model;

import bridge.domain.BridgeMaker;

import java.util.List;

public class Bridge {

    private BridgeMaker bridgeMaker;

    Bridge(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    private List<String> bridge;

    public void setBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
