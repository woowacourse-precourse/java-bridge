package bridge.validator;

import java.util.regex.Pattern;

import static bridge.exception.InputException.*;

public class InputValidator {
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private InputValidator() {
    }

    public static int checkBridgeSize(String size) {
        validateOnlyNumber(size);
        validateMinSize(Integer.parseInt(size));
        validateMaxSize(Integer.parseInt(size));
        return Integer.parseInt(size);
    }

    private static void validateOnlyNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            printNotOnlyNumberException();
        }
    }

    private static void validateMinSize(int size) {
        if(size < MIN_SIZE) {
            printNotMinSizeException();
        }
    }

    private static void validateMaxSize(int size) {
        if(size > MAX_SIZE) {
            printNotMaxSizeException();
        }
    }
}
