package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Direction> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = initBridge(bridge);
    }

    private List<Direction> initBridge(List<String> bridge) {
        return bridge.stream()
            .map(Direction::of)
            .collect(Collectors.toList());
    }

    public boolean isMove(BridgeIndex bridgeIndex, Direction selectDirection) {
         Direction Direction = bridge.get(bridgeIndex.getIndex());
         return Direction == selectDirection;
    }
}
