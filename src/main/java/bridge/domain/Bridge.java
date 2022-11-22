package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge initBridge(List<String> bridge) {
        Bridge bridgeInstance = new Bridge(bridge);
        return bridgeInstance;
    }

    private String getBridgeLocation(int location) {
        return bridge.get(location);
    }
}