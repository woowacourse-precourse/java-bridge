package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Direction> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = toDirection(bridge);
    }

    private List<Direction> toDirection(List<String> bridge) {
        return bridge.stream().map(Direction::valueOf).collect(Collectors.toList());
    }
}
