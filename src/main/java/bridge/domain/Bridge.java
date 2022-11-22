package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(int size) {
        this.bridge = makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }
}
