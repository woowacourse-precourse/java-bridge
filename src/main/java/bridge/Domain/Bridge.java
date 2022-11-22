package bridge.Domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> bridge;
    private int bridgeSize;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeSize = bridge.size();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(this.bridge);
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }
}
