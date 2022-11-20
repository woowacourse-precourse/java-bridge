package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public String get(int index) {
        return bridge.get(index);
    }

    public int size() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
