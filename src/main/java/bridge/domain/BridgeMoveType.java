package bridge.domain;

import java.util.Arrays;

import static bridge.exception.BridgeTypeExceptionMessage.READ_WRONG_TYPE_EXCEPTION;

public enum BridgeMoveType {
    UP("U", 0),
    DOWN("D", 1);

    private final String type;
    private final int code;

    BridgeMoveType(String type, int code) {
        this.type = type;
        this.code = code;
    }

    public static BridgeMoveType of(String bridgeType) {
        return Arrays.stream(BridgeMoveType.values())
                .filter(bridge -> bridge.type.equals(bridgeType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(READ_WRONG_TYPE_EXCEPTION.getMessage()));
    }

    public static String typeOf(int bridgeCode) {
        return Arrays.stream(BridgeMoveType.values())
                .filter(bridge -> bridge.code == bridgeCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(READ_WRONG_TYPE_EXCEPTION.getMessage()))
                .type;
    }

    public boolean isSame(BridgeMoveType bridgeMoveType) {
        return this == bridgeMoveType;
    }
}
