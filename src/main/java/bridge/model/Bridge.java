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

    public boolean isMovable(int position, Direction direction) {
        return bridge.get(position) == direction;
    }

    public boolean end(int position) {
        return bridge.size() == position;
    }
}
