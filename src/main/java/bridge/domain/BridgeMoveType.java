package bridge.domain;

import java.util.Arrays;

import static bridge.exception.BridgeTypeExceptionMessage.READ_WRONG_TYPE_EXCEPTION;

public enum BridgeMoveType {
    UP("U", 1),
    DOWN("D", 0);

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

    public static String of(int bridgeCode) {
        return Arrays.stream(BridgeMoveType.values())
                .filter(bridge -> bridge.code == bridgeCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(READ_WRONG_TYPE_EXCEPTION.getMessage()))
                .type;
    }

    public static boolean isMoveTypeExists(String moveType) {
        return Arrays.stream(BridgeMoveType.values())
                .anyMatch(bridgeMoveType -> bridgeMoveType.type.equals(moveType));
    }

    public boolean isSame(BridgeMoveType bridgeMoveType) {
        return this == bridgeMoveType;
    }

    public boolean isNotSame(BridgeMoveType answerMoveType) {
        return this != answerMoveType;
    }
}
