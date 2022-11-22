package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean ableToMove(String location, int index) {
        if (location.equals(bridge.get(index))) {
            return true;
        }
        return false;
    }
}
