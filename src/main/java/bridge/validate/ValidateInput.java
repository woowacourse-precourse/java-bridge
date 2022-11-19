package bridge.validate;

import static bridge.util.Constants.ExceptionConstants.*;

public class ValidateInput {
    public static void validateBridgeSize(String input) {
        isBridgeSizeBetween3And20(validateInputBridgeSize(input));
    }

    public static int validateInputBridgeSize(String input) {
        if (!input.matches(INTEGER_ONLY_REGEX)) {
            throw new IllegalArgumentException(INPUT_ONLY_INTEGER);
        }
        return Integer.parseInt(input);
    }

    private static void isBridgeSizeBetween3And20(int input) {
        if (input < 3 || 20 < input) {
            throw new IllegalArgumentException(BRIDGE_SIZE_BETWEEN_3_AND_20);
        }
    }
}
