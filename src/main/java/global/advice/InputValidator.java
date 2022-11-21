package global.advice;

import static bridge.BridgeMaker.TOP_ROW;
import static bridge.BridgeMaker.UNDER_ROW;
import static global.advice.ErrorMessage.CHECK_MOVING;
import static global.advice.ErrorMessage.CHECK_RETRY;
import static global.advice.ErrorMessage.CHECK_SIZE;
import static global.advice.ErrorMessage.CHECK_SIZE_DIGIT;
import static global.advice.ErrorMessage.makeErrorMessage;

public class InputValidator {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 2;
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static final String RETRY_SIGNAL = "R";
    public static final String QUIT_SIGNAL = "Q";

    private InputValidator(){}

    public static void checkLength(final String size) {
        if (size.length() < MIN_LENGTH || size.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(makeErrorMessage(CHECK_SIZE) + size);
        }
    }

    public static void checkIsDigit(final String size) {
        for (String number : size.split("")) {
            validateDigit(number);
        }
    }

    private static void validateDigit(final String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException(makeErrorMessage(CHECK_SIZE_DIGIT) + number);
        }
    }

    public static void checkRange(final String size) {
        if (MIN_SIZE > Integer.parseInt(size) || MAX_SIZE < Integer.parseInt(size)) {
            throw new IllegalArgumentException(makeErrorMessage(CHECK_SIZE) + size);
        }
    }

    public static void checkMoving(final String moving) {
        if (!TOP_ROW.equals(moving) && !UNDER_ROW.equals(moving)) {
            throw new IllegalArgumentException(makeErrorMessage(CHECK_MOVING) + moving);
        }
    }

    public static void checkRetryWhether(final String retry) {
        if (!RETRY_SIGNAL.equals(retry) && !QUIT_SIGNAL.equals(retry)) {
            throw new IllegalArgumentException(makeErrorMessage(CHECK_RETRY) + retry);
        }
    }
}
