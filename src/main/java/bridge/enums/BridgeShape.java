package bridge.enums;

import bridge.constant.ErrorConstant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeShape {

    CAN_MOVE(" O ", true),
    CANNOT_MOVE(" X ", false);

    private final String shape;
    private final boolean canMove;

    BridgeShape(String shape, boolean canMove) {
        this.shape = shape;
        this.canMove = canMove;
    }

    public static String getNextShape(boolean canMove) {
        return Arrays.stream(BridgeShape.values())
                .filter(bridgeShape -> bridgeShape.canMove == canMove)
                .map(bridgeShape -> bridgeShape.shape)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ErrorConstant.ERROR_PREFIX + "해당 모양을 찾을 수 없습니다."));
    }
}
