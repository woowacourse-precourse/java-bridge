package bridge.domain;

import bridge.domain.user.MoveType;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge initBridge(List<String> bridge) {
        Bridge bridgeInstance = new Bridge(bridge);
        return bridgeInstance;
    }

    public boolean canCross(int location, MoveType moveType) {
        return moveType.compareTo(getBridgeLocation(location));
    }

    private String getBridgeLocation(int location) {
        return bridge.get(location);
    }

    public int getBridgeEnd() {
        return bridge.size() - 1;
    }
}