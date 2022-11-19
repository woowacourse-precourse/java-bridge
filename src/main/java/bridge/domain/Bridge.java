package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isRightTrack(int location, String direction) {
        if (bridge.get(location).equals(direction)) {
            return true;
        }
        return false;
    }
}
