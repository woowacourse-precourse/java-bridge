package bridge.util;

import bridge.domain.errorenum.ErrorMessage;

public class InputValidator {
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String UPPER_CASE_REGEX = "[A-Z]+";

    private InputValidator() {
    }

    public static void validateNumber(String input) {
        if (input.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.printMessage());
    }

    public static void validateOnlyString(String input) {
        if (input.matches(UPPER_CASE_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_UPPER_CASE.printMessage());
    }

}
