package bridge.service;

import static bridge.view.Message.*;

public class Validator {
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final String UP = "U";
    public static final String DOWN = "D";

    public static String checkRetryQuit(String input) {
        if (input.equals(RETRY) || input.equals(QUIT)) {
            return input;
        }
        throw new IllegalArgumentException(ERROR_NOT_RETRY_QUIT);
    }

    public static Character checkUpDown(String input) {
        if (input.equals(UP) || input.equals(DOWN)) {
            return input.charAt(0);
        }
        throw new IllegalArgumentException(ERROR_NOT_UP_DOWN);
    }

    public static int checkInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(ERROR_OVER_RANGE);
        }
    }
}
