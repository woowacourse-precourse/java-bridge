package bridge.option;

import static bridge.config.ExceptionMessage.NOT_ALL_UPPERCASE;

import bridge.config.ExceptionMessage;

public class Option {
    private static final String ONLY_UPPERCASE_REGEXP ="^[A-Z]+$";

    private final String option;

    public Option(String option) {
        validate(option);
        this.option = option;
    }

    public static void validate(String option) {
        validateOnlyUppercase(option);
    }

    private static void validateOnlyUppercase(String option) {
        if (!option.matches(ONLY_UPPERCASE_REGEXP)) {
            throw new IllegalArgumentException(NOT_ALL_UPPERCASE.toString());
        }
    }
}
