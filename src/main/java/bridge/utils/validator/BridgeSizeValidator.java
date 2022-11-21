package bridge.utils.validator;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;

public class BridgeSizeValidator {
    private static final int SIZE_MIN_RANGE = 3;
    private static final int SIZE_MAX_RANGE = 20;

    private BridgeSizeValidator() {
    }

    public static void validate(String bridgeSize) {
        validateInteger(bridgeSize);
        validateBridgeSize(bridgeSize);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private static void validateBridgeSize(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < SIZE_MIN_RANGE || bridgeSize > SIZE_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }
}
