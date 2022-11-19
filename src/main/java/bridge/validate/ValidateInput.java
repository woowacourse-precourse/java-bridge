package bridge.validate;

import bridge.util.TypeConverter;

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

    public static void validateMovingBlock(String input) {
        isOnlyUOrD(isInputLength1(input));
    }

    private static char isInputLength1(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INPUT_LENGTH_ONLY_1);
        }
        return TypeConverter.stringToChar(input);
    }

    private static void isOnlyUOrD(char input) {
        if (input != 'U' && input != 'D') {
            throw new IllegalArgumentException(INPUT_ONLY_U_OR_D);
        }
    }

    public static void validateRestartGameWhether(String restartGameWhether) {
        isOnlyROrQ(isInputLength1(restartGameWhether));
    }

    private static void isOnlyROrQ(char input) {
        if (input != 'R' && input != 'Q') {
            throw new IllegalArgumentException(INPUT_ONLY_U_OR_D);
        }
    }
}
