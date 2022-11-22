package bridge.model;

import static bridge.model.Position.isSame;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSamePosition(int index, Position position) {
        return Position.isSame(bridge.get(index), position);
    }

    public int size() {
        return bridge.size();
    }
}
