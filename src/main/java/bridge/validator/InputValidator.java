package bridge.validator;

import java.util.regex.Pattern;

import static bridge.exception.InputException.*;

public class InputValidator {
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";

    private InputValidator() {
    }

    public static int checkBridgeSize(String size) {
        validateOnlyNumber(size);
        return Integer.parseInt(size);
    }

    private static void validateOnlyNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            printNotOnlyNumberException();
        }
    }
}
