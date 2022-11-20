package bridge.domain.bridge;

import bridge.value.BridgeCharacter;

public class BridgePasser {
    private int location;
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

    public void move() {
        if(!bridge.isRange(location + 1)) {
            throw new IllegalStateException("더이상 이동할 수 없습니다.");
        }
        addLocation();
    }

    private void addLocation() {
        this.location += 1;
    }

    public boolean isBridgeEnd() {
        return !bridge.isRange(location + 1);
    }

}
