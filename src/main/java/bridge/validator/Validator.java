package bridge.validator;

public class Validator {
    public static final int LOWER_BRIDGE_SIZE_BOUND = 3;
    public static final int UPPER_BRIDGE_SIZE_BOUND = 20;

    public void checkValidBridgeSize(String bridgeSize) {
        checkEmptyStr(bridgeSize);
        checkNumberFormat(bridgeSize);
        checkValidNumberRange(bridgeSize);
    }

    public void checkValidMoveInput(String moveInput) {
        checkEmptyStr(moveInput);
        checkMoveFormat(moveInput);
    }

    public void checkValidRetryInput(String retryInput) {
        checkEmptyStr(retryInput);
        checkRetryFormat(retryInput);
    }

    private void checkEmptyStr(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ErrorType.EMPTY_INPUT.getMessage());
        }
    }

    private static void checkNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                throw new IllegalArgumentException(ErrorType.INVALID_FORMAT.getMessage());
            }
        }
    }

    private static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private void checkValidNumberRange(String str) {
        int number = Integer.parseInt(str);

        if (!isValidRange(number)) {
            throw new IllegalArgumentException(ErrorType.INVALID_RANGE.getMessage());
        }
    }

    private boolean isValidRange(int number) {
        return LOWER_BRIDGE_SIZE_BOUND <= number && number <= UPPER_BRIDGE_SIZE_BOUND;
    }

    private static void checkRetryFormat(String retryInput) {
        if (!RetryType.isValidInput(retryInput)) {
            throw new IllegalArgumentException(ErrorType.INVALID_RETRY_INPUT.getMessage());
        }
    }

    private static void checkMoveFormat(String moveInput) {
        if (!MovingType.isValidInput(moveInput)) {
            throw new IllegalArgumentException(ErrorType.INVALID_MOVE_INPUT.getMessage());
        }
    }
}
