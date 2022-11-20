package bridge.domain;

import bridge.constant.Direction;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Direction> bridge;

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    private Bridge(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(Direction::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean canMove(Direction userDirection, int location) {
        return bridge.get(location).equals(userDirection);
    }

    public boolean isEnd(int location) {
        return bridge.size() == location;
    }
}
