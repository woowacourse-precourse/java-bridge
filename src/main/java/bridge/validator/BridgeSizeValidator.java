package bridge.validator;

import bridge.common.ErrorCode;

public class BridgeSizeValidator {
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 20;

    public static int validate(String input) {
        int size = Integer.parseInt(input);
        if (isInvalidRange(size)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MOVING.getMessage());
        }

        return size;
    }

    private static boolean isInvalidRange(int input) {
        return input < MIN_VALUE || input > MAX_VALUE;
    }
}
