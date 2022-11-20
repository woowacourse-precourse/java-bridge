package bridge.model;

import bridge.view.ErrorMessage;

public class Validator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

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
}
