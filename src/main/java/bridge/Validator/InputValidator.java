package bridge.Validator;

import static bridge.Validator.Constants.ErrorConstants.*;
import static bridge.View.Constants.InputConstants.*;

public class InputValidator {
    public static void validateNumeric(String input) {
        boolean isNumeric = isNumeric(input);
        if (!isNumeric) {
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public static void validateRange(int input) {
        if (input < MIN_VALUE_LENGTH_OF_BRIDGE || input > MAX_VALUE_LENGTH_OF_BRIDGE) {
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static void validateUpOrDown(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {

            throw new IllegalArgumentException(ERROR_FOR_UP_OR_DOWN);
        }
    }

    public static void validateRetryOrQuit(String input) {
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            throw new IllegalArgumentException(ERROR_FOR_RETRY_OR_QUIT);
        }
    }
}
