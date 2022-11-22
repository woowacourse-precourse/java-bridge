package bridge.Validator;

import static bridge.Validator.Constants.ErrorConstants.*;

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
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static void validateUpOrDown(String input) {
        String UP = "U";
        String DOWN = "D";
        if (!(input.equals(UP) || input.equals(DOWN))) {

            throw new IllegalArgumentException(ERROR_FOR_UP_OR_DOWN);
        }
    }

    public static void validateRetry(String input) {
        String RETRY = "R";
        String QUIT = "Q";
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            throw new IllegalArgumentException(ERROR_FOR_RETRY_OR_QUIT);
        }
    }
}
