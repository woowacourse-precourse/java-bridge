package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatch(int idx, String input) {
        if (bridge.get(idx).equals(input)) {
            return true;
        }
        return false;
    }

    public int size() {
        return bridge.size();
    }
}
