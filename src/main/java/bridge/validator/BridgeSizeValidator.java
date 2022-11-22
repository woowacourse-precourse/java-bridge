package bridge.validator;

import bridge.common.ErrorCode;

public class BridgeSizeValidator {
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 20;

    public static int validate(String input) {
        int size = isValidInt(input);
        if (isInvalidRange(size)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BRIDGE_SIZE.getMessage());
        }
        return size;
    }

    private static int isValidInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BRIDGE_SIZE_TYPE.getMessage());
        }
    }

    private static boolean isInvalidRange(int input) {
        return input < MIN_VALUE || input > MAX_VALUE;
    }
}
