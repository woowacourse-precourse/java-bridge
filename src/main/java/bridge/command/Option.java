package bridge.command;

import static bridge.config.ExceptionMessage.NOT_ALL_UPPERCASE;
import static bridge.config.ExceptionMessage.WRONG_OPTION_LENGTH;

public class Option {
    private static final String ONLY_UPPERCASE_REGEXP ="^[A-Z]+$";
    private static final int OPTION_LENGTH = 1;

    public static void validate(String option) {
        validateOnlyUppercase(option);
        validateOptionLength(option);
    }

    private static void validateOnlyUppercase(String option) {
        if (!option.matches(ONLY_UPPERCASE_REGEXP)) {
            throw new IllegalArgumentException(NOT_ALL_UPPERCASE.toString());
        }
    }

    private static void validateOptionLength(String option) {
        if (option.length() != OPTION_LENGTH) {
            throw new IllegalArgumentException(WRONG_OPTION_LENGTH.toString());
        }
    }
}
