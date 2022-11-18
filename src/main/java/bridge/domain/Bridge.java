package bridge.domain;

import java.util.List;

final class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int size() {
        return bridge.size();
    }

    public boolean isEqualAtIndex(int index, Position position) {
        return position == Position.from(bridge.get(index));
    }
}
