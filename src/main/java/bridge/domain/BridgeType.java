package bridge.domain;

import java.util.Arrays;

import static bridge.exception.BridgeTypeExceptionMessage.READ_WRONG_TYPE_EXCEPTION;

public enum BridgeType {
    DOWN("U", 0),
    UP("D", 1);

    private final String type;
    private final int code;

    BridgeType(String type, int code) {
        this.type = type;
        this.code = code;
    }

    public static BridgeType of(String bridgeType) {
        return Arrays.stream(BridgeType.values())
                .filter(bridge -> bridge.type.equals(bridgeType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(READ_WRONG_TYPE_EXCEPTION.getMessage()));
    }

    public static String typeOf(int bridgeCode) {
        return Arrays.stream(BridgeType.values())
                .filter(bridge -> bridge.code == bridgeCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(READ_WRONG_TYPE_EXCEPTION.getMessage()))
                .type;
    }
}
