package bridge.util;

import bridge.domain.errorenum.ErrorMessage;

public class InputValidator {
    private static final String NUMBER_REGEX = "[0-9]+";

    private InputValidator() {
    }

    public static void validateNumber(String input) {
        if (input.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.printMessage());
    }

}
