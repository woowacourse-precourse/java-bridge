package bridge.view.console;

import bridge.Validator;

public class ReaderValidator extends Validator {
    public static void validateNumber(String value) {
        validateNotNull(value);
        validateNotEmpty(value);
        validateInteger(value);
    }

    public static void validateString(String value) {
        validateNotNull(value);
        validateNotEmpty(value);
    }
}
