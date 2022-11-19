package global.advice;

import static bridge.BridgeMaker.TOP_ROW;
import static bridge.BridgeMaker.UNDER_ROW;

public class InputValidator {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 2;
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static final String RETRY_SIGNAL = "R";
    public static final String QUIT_SIGNAL = "Q";

    private InputValidator(){}

    public static void checkLength(String size) {
        if (size.length() < MIN_LENGTH || size.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsDigit(String size) {
        for (String number : size.split("")) {
            validateDigit(number);
        }
    }

    private static void validateDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRange(String size) {
        if (MIN_SIZE > Integer.parseInt(size) || MAX_SIZE < Integer.parseInt(size)) {
            throw new IllegalArgumentException();
        }
    }
}
