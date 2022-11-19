package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(String direction, int location) {
        return bridge.get(location).equals(direction);
    }

    public boolean isEnd(int location) {
        return bridge.size() == location;
    }
}
