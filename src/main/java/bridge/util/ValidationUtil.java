package bridge.util;

import bridge.enums.ErrorMessage;

/**
 * 입력 검증 로직
 */
public class ValidationUtil {

    /**
     * 다리 길이가 1 이상인지 확인한다.
     *
     * @param size 다리의 길이
     */
    public static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_LENGTH_INPUT.getMessage());
        }
    }

    /**
     * 이동 방향이 U 또는 D가 맞는지 확인한다.
     *
     * @param direction 다음 이동 방향 (U/D)
     */
    public static void validateMove(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIRECTION_INPUT.getMessage());
        }
    }

    /**
     * 게임 재개 입력이 R 또는 Q가 맞는지 확인한다.
     *
     * @param retry 게임 재개 여부 (R/Q)
     */
    public static void validateWhetherToRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_INPUT.getMessage());
        }
    }
}
