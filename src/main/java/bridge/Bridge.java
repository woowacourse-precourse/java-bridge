package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCross(int location, String direction) {
        return bridge.get(location).equals(direction);
    }

    public int size() {
        return bridge.size();
    }
}
