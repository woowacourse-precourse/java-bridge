package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCross(int position, Direction direction) {
        return bridge.get(position).equals(direction.getCommand());
    }

    public int size() {
        return bridge.size();
    }
}
