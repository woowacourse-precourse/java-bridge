package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<Direction> bridge;

    public Bridge(List<Direction> bridge) {
        this.bridge = bridge;
    }

    public Direction getDirection(BridgeIndex bridgeIndex) {
        return bridge.get(bridgeIndex.getIndex());
    }
}
