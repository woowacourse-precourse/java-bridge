package bridge.utils;

import bridge.utils.enums.BridgeRule;
import bridge.utils.enums.Errors;
import bridge.utils.enums.MoveFormat;
import bridge.utils.enums.RetryFormat;

public class Validator {
    public static void checkSizeInRange(int size) {
        int minLength = BridgeRule.MIN_LENGTH.getValue();
        int maxLength = BridgeRule.MAX_LENGTH.getValue();
        if (minLength > size || size > maxLength) {
            String errorMessage = String.format(Errors.RANGE.getMessage(), minLength, maxLength);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkMoveInput(String moveInput) {
        if (!MoveFormat.MOVE_UP.isEqual(moveInput) && !MoveFormat.MOVE_DOWN.isEqual(moveInput)) {
            throw new IllegalArgumentException(Errors.UNREQUIRED.getMessage());
        }
    }

    public static void checkRetryInput(String retryInput) {
        if (!RetryFormat.RETRY.isEqual(retryInput) && !RetryFormat.QUIT.isEqual(retryInput)) {
            throw new IllegalArgumentException(Errors.UNREQUIRED.getMessage());
        }
    }
}
