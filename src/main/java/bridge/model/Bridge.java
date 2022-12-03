package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSamePosition(int index, Position position) {
        return position.isSame(bridge.get(index));
    }

    public int size() {
        return bridge.size();
    }
}
