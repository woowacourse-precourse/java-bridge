package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSamePosition(Bridge other, int index) {
        return this.bridge.get(index).equals(other.bridge.get(index));
    }

    public List<String> getBridge() {
        return bridge;
    }
}
