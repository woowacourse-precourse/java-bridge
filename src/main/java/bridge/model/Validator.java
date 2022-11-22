package bridge.model;

import bridge.view.ErrorMessage;

public class Validator {

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
        if (n < Constants.MIN_SIZE || n > Constants.MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateMove(String input) {
        if (!input.equals(Constants.UP) && !input.equals(Constants.DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_U_OR_D_POSSIBLE.getMessage());
        }
    }

    public static void validateCommand(String input) {
        if (!input.equals(Constants.RESTART) && !input.equals(Constants.QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_R_OR_Q_POSSIBLE.getMessage());
        }
    }
}
