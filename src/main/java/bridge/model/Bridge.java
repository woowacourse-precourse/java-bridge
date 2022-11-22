package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Direction> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = toDirection(bridge);
    }

    private List<Direction> toDirection(List<String> bridge) {
        return bridge.stream().map(Direction::fromInput).collect(Collectors.toList());
    }

    public boolean isBroken(int position, Direction direction) {
        return bridge.get(position) != direction;
    }

    public boolean isEnded(int position) {
        return bridge.size() - 1 == position;
    }
}
