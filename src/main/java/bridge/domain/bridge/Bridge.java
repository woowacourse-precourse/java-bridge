package bridge.domain.bridge;

import bridge.domain.direction.Direction;

import java.util.List;

public class Bridge {

    private final List<Direction> bridge;

    public Bridge(List<Direction> bridge) {
        this.bridge = bridge;
    }
}
