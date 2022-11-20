package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    Bridge(int size) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
