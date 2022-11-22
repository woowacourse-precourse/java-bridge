package bridge.domain.bridge;

import bridge.common.ErrorCode;

import java.util.Arrays;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int type;
    private final String initial;

    BridgeDirection(int type, String initial) {
        this.type = type;
        this.initial = initial;
    }

    public static BridgeDirection of(String initial) {
        return Arrays.stream(values())
                .filter(dir -> dir.initial.equals(initial))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_BRIDGE_DIRECTION.getMessage()));
    }

    public static BridgeDirection of(int type) {
        return Arrays.stream(values())
                .filter(dir -> dir.type == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_BRIDGE_DIRECTION.getMessage()));
    }

    public String getInitial() {
        return initial;
    }
}
