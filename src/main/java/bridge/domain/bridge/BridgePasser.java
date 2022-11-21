package bridge.domain.bridge;

import static bridge.domain.BridgeLocation.initBridgeLocation;
import static bridge.validate.BridgeValidation.validateBridgeMovable;

import bridge.domain.BridgeLocation;
import bridge.value.BridgeCharacter;

public class BridgePasser {
    private BridgeLocation bridgeLocation;
    private final Bridge bridge;

    public BridgePasser(BridgeLocation bridgeLocation, Bridge bridge) {
        this.bridgeLocation = bridgeLocation;
        this.bridge = bridge;
    }

    public static BridgePasser makeBridgePasser(Bridge bridge) {
        return new BridgePasser(initBridgeLocation(), bridge);
    }

    public boolean canMove(BridgeCharacter bridgeCharacter) {
        return bridge.canMove(bridgeLocation, bridgeCharacter);
    }

    public void move() {
        validateBridgeMovable(bridge.isRange(bridgeLocation.next()));

        addLocation();
    }

    private void addLocation() {
        this.bridgeLocation = bridgeLocation.next();
    }

    public boolean isBridgeEnd() {
        return !bridge.isRange(bridgeLocation.next());
    }

    public void clear() {
        this.bridgeLocation = initBridgeLocation();
    }

    public BridgeLocation getLocation() {
        return bridgeLocation;
    }
}
