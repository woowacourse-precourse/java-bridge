package bridge.utils;

import bridge.Bridge;
import bridge.BridgeDirection;

public class Validator {
    private static final String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String DIRECTION_ERROR = "[ERROR] 방향은 U와 D만 입력해주세요.";

    public static void checkSizeRange(int size) {
        if (isUnderMin(size) || isOverMax(size)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public static void checkMovingDirection(String direction) {
        if (!isUp(direction) && !isDown(direction)) {
            throw new IllegalArgumentException(DIRECTION_ERROR);
        }
    }

    private static boolean isUnderMin(int size) {
        return size < Bridge.MIN;
    }

    private static boolean isOverMax(int size) {
        return size > Bridge.MAX;
    }

    private static boolean isUp(String direction) {
        return direction.equals(BridgeDirection.UP.getDirection());
    }

    private static boolean isDown(String direction) {
        return direction.equals(BridgeDirection.DOWN.getDirection());
    }
}
