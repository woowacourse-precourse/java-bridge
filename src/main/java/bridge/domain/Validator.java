package bridge.domain;

import bridge.vo.ErrorMessage;

public class Validator {

    public static void validateBridgeSize(String bridgeSize) {
        validateNumber(bridgeSize);
        validateRange(bridgeSize);
    }

    public static void validateMoving(String moving) {
        if (!moving.matches("^[U]$|^[D]$")) {
            throwIllegalArgumentException(ErrorMessage.MOVING_WRONG_INPUT);
        }
    }

    public static void validateRestartChoice(String restartChoice) {
        if (!restartChoice.matches("^[R]$|^[Q]$")) {
            throwIllegalArgumentException(ErrorMessage.RESTART_WRONG_INPUT);
        }
    }

    private static void validateNumber(String bridgeSize) {
        if (!bridgeSize.matches("\\d+")) {
            throwIllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_NUMBER);
        }
    }

    private static void validateRange(String bridgeSize) {
        if (!bridgeSize.matches("^[3-9]$|^1\\d$|^20$")) {
            throwIllegalArgumentException(ErrorMessage.BRIDGE_SIZE_WRONG_RANGE);
        }
    }

    private static void throwIllegalArgumentException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.getErrorMessage());
    }
}
