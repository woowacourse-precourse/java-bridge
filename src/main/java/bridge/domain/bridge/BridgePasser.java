package bridge.domain.bridge;

import bridge.value.BridgeCharacter;

public class BridgePasser {
    private final int location;
    private final Bridge bridge;

    public BridgePasser(int location, Bridge bridge) {
        this.location = location;
        this.bridge = bridge;
    }

    public static BridgePasser makeBridgePasser(Bridge bridge) {
        return new BridgePasser(0, bridge);
    }

    public boolean canMove(BridgeCharacter bridgeCharacter) {
        return bridge.canMove(location, bridgeCharacter);
    }

}
