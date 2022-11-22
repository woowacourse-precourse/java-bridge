package bridge.Model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    public void saveCrossedBridge(final String crossed) {
        bridge.add(crossed);
    }

    public String getLocationValue(final int index) {
        return bridge.get(index);
    }
}
