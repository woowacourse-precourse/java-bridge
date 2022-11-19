package bridge.domain.bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public String passableDirectionAt(int distance) {
        return bridge.get(distance);
    }
}
