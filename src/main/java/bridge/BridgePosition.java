package bridge;

import java.util.Arrays;

import static bridge.exception.Errors.INVALID_PARAMETER;

public enum BridgePosition {
    BRIDGE_POSITION_UP("U", 1),
    BRIDGE_POSITION_DOWN("D", 0);

    private final String name;
    private final int position;

    BridgePosition(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static String from(final int position) {
        BridgePosition bridge = Arrays.stream(values())
                .filter(bridgePosition -> bridgePosition.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(INVALID_PARAMETER.getMessage()));

        return bridge.name;
    }

    private boolean isSamePosition(final int position) {
        return this.position == position;
    }
}
