package bridge.domain;

import bridge.vo.ErrorMessage;

public class Validator {

    public static void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches("^[3-9]$|^1\\d$|^20$")) {
            throwIllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_NUMBER);
        }
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

    private static void throwIllegalArgumentException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.getErrorMessage());
    }
}
