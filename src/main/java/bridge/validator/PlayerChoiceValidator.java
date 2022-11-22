package bridge.validator;

import static bridge.validator.ExceptionMessage.*;

import java.util.regex.Pattern;

public class PlayerChoiceValidator {

    public static final String STRING_REGEX = "^[a-zA-Z]*$";

    public static void validate(String input, String choice, String otherChoice) {
        validateBlank(input);
        validateString(input);
        validateOption(input, choice, otherChoice);
    }

    private static void validateOption(String choice, String option, String otherOption) {
        if (!choice.equals(option) && !choice.equals(otherOption)) {
            throw new IllegalArgumentException(
                String.format(FORMAT_OPTION_ERROR_MESSAGE, option, otherOption));
        }
    }

    private static void validateString(String choice) {
        if (!Pattern.matches(STRING_REGEX, choice)) {
            throw new IllegalArgumentException(
                String.format(STRING_FORMAT_ERROR_MESSAGE, choice)
            );
        }
    }

    private static void validateBlank(String choice) {
        if (choice.isBlank()) {
            throw new IllegalArgumentException(
                BLANK_ERROR_MESSAGE
            );
        }
    }
}
