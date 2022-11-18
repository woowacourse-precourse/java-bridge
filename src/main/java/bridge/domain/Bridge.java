package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
