package bridge.validate;

import bridge.util.CustomException;
import bridge.util.TypeConverter;

import static bridge.util.Constants.InputViewConstants.*;
import static bridge.util.Constants.OutputViewConstants.*;
import static bridge.util.ErrorCode.*;

public class ValidateInput {
    public static void validateBridgeSize(String input) {
        isBridgeSizeBetween3And20(validateInputBridgeSize(input));
    }

    private static int validateInputBridgeSize(String input) {
        if (!input.matches(INTEGER_ONLY_REGEX.getMessage())) {
            throw new CustomException(INPUT_ONLY_INTEGER);
        }
        return Integer.parseInt(input);
    }

    private static void isBridgeSizeBetween3And20(int input) {
        if (input < 3 || 20 < input) {
            throw new CustomException(BRIDGE_SIZE_BETWEEN_3_AND_20);
        }
    }

    public static void validateMovingBlock(String input) {
        isOnlyUOrD(isInputLength1(input));
    }

    private static char isInputLength1(String input) {
        if (input.length() != 1) {
            throw new CustomException(INPUT_LENGTH_ONLY_1);
        }
        return TypeConverter.stringToChar(input);
    }

    private static void isOnlyUOrD(char input) {
        if (input != UP.getMessage().charAt(0) && input != DOWN.getMessage().charAt(0)) {
            throw new CustomException(INPUT_ONLY_U_OR_D);
        }
    }

    public static void validateRestartGameWhether(String restartGameWhether) {
        isOnlyROrQ(isInputLength1(restartGameWhether));
    }

    private static void isOnlyROrQ(char input) {
        if (input != RESTART.getMessage().charAt(0) && input != QUIT.getMessage().charAt(0)) {
            throw new CustomException(INPUT_ONLY_U_OR_D);
        }
    }
}
