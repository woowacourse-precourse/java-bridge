package bridge.bridge;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_POSITION;

import java.util.Arrays;

public enum BridgePosition {
    BRIDGE_UP("U"),
    BRIDGE_DOWN("D");

    private final String position;

    BridgePosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public static BridgePosition fromString(String moving) {
        return Arrays.stream(BridgePosition.values())
                .filter(bridgePosition -> bridgePosition.getPosition().equals(moving))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ILLEGAL_BRIDGE_POSITION.getMessage()));
    }
}
