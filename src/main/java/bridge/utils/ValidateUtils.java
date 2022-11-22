package bridge.utils;

import static bridge.view.message.ErrorMessage.*;

public class ValidateUtils {

    public static void validateNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
        }
    }

    public static int validateNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(VALIDATE_INTEGER_TYPE_ERROR);
        }
    }

    public static void validateMoveType(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException(INPUT_MOVE_TYPE_ERROR);
        }
    }

    public static void validateGameRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(INPUT_RETRY_ERROR);
        }
    }
}
