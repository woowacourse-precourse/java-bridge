package bridge.model;

import bridge.view.ErrorMessage;

public class Validator {
    public static void validateSize(String input) {
        isNumber(input);
    }

    private static void isNumber(String input) {
        String pattern = "^[0-9]*$";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
        }
    }
}
