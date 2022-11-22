package bridge.domain.bridgeGame;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int bridgeSize;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeSize = bridge.size();
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public int size() {
        return bridgeSize;
    }

    public String passableDirectionAt(int distance) {
        return bridge.get(distance);
    }
}
