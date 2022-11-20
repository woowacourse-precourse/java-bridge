package bridge.model;

import bridge.view.ErrorMessage;

public class Validator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static void validateSize(String input) {
        isNumber(input);
        isInRange(input);
    }

    private static void isNumber(String input) {
        String pattern = "^(-?)[0-9]+$";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
        }
    }

    private static void isInRange(String input) {
        int n = Integer.parseInt(input);
        if (n < MIN_SIZE || n > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateMove(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_U_OR_D_POSSIBLE.getMessage());
        }
    }

    public static void validateCommand(String input) {
        if (!input.equals(RESTART) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_R_OR_Q_POSSIBLE.getMessage());
        }
    }
}
