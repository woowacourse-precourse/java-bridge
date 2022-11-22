package bridge.model;

import java.util.List;

public class Bridge {
    private int bridgeSize;
    private List<String> bridge;

    public Bridge(int bridgeSize, List<String> bridge) {
        this.bridge = bridge;
        this.bridgeSize = bridgeSize;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
