package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatch(int idx, String direction) {
        if (bridge.get(idx).equals(direction)) {
            return true;
        }
        return false;
    }
}
