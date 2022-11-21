package bridge.validator;

import static bridge.validator.ExceptionMessage.*;

import java.util.regex.Pattern;

public class BridgeSizeValidator {

    private static final int MAX = 20;
    private static final int MIN = 3;
    public static final String NUMBER_REGEX = "^[0-9]*$";

    public static void validate(String size) {
        validateBlank(size);
        validateDigit(size);
        validateSize(toInt(size));
    }

    private static int toInt(String size) {
        return Integer.parseInt(size);
    }

    private static void validateSize(int size) {
        if (size < MIN || size > MAX) {
            throw new IllegalArgumentException(
                String.format(SIZE_RANGE_ERROR_MESSAGE, size));
        }
    }

    private static void validateDigit(String size) {
        if (!Pattern.matches(NUMBER_REGEX, size)) {
            throw new IllegalArgumentException(
                String.format(NUMBER_FORMAT_ERROR_MESSAGE, size));
        }
    }

    private static void validateBlank(String size) {
        if (size.isBlank()) {
            throw new IllegalArgumentException(
                BLANK_ERROR_MESSAGE
            );
        }
    }
}
