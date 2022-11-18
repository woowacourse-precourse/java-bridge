package bridge.validator;

import bridge.ErrorType;

public class Validator {
    public static final int LOWER_BRIDGE_SIZE_BOUND = 3;
    public static final int UPPER_BRIDGE_SIZE_BOUND = 20;

    public void checkValidBridgeSize(String bridgeSize) {
        checkNumberFormat(bridgeSize);
        checkValidNumberRange(bridgeSize);
    }

    public void checkValidMoveInput(String moveInput) {
        if (!InputType.MOVE.isValidInput(moveInput)) {
            throw new IllegalArgumentException(ErrorType.INVALID_MOVE_INPUT.getErrorMsg());
        }
    }

    public void checkValidRetryInput(String moveInput) {
        if (!InputType.RETRY.isValidInput(moveInput)) {
            throw new IllegalArgumentException(ErrorType.INVALID_RETRY_INPUT.getErrorMsg());
        }
    }

    private static void checkNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getErrorMsg());
            }
        }
    }

    private static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private void checkValidNumberRange(String str) {
        int number = Integer.parseInt(str);

        if (!isValidRange(number)) {
            throw new IllegalArgumentException(ErrorType.INVALID_RANGE.getErrorMsg());
        }
    }

    private boolean isValidRange(int number) {
        return LOWER_BRIDGE_SIZE_BOUND <= number && number <= UPPER_BRIDGE_SIZE_BOUND;
    }
}
