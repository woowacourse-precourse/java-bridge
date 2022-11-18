package bridge.util.validator;

import static bridge.util.Error.*;

public class InputValidator {
    public static void bridgeSizeValidate(String input) {
        if (!input.matches("[1-2]?\\d")) {
            throw new IllegalArgumentException(OUT_OF_RANGE.toString());
        }

        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE.toString());
        }
    }

    public static void moveDirectionValidate(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(NOT_U_NOR_D.toString());
        }
    }

    public static void retryValidate(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(NOT_R_NOR_Q.toString());
        }
    }
}
