package bridge;

import static bridge.Errors.*;

public class Validator {
    private static final String pattern = "[0-9]*$";

    public static void numberValidate(String number) {
        if (!(number.matches(pattern))) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void bridgeSizeValidate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(RANGE_SIZE_ERROR.getMessage());   //3~20
        }
    }

    public static void moveValidate(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(MOVE_ERROR.getMessage());   //U or D
        }
    }

    public static void reStartValidate(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(REPLAY_ERROR.getMessage());   //R or Q
        }
    }
}
