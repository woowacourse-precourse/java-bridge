package bridge.view;

import bridge.constant.ErrorMessage;
import bridge.view.constant.ValidationRegex;

import java.util.regex.Pattern;

public class ViewValidator {
    public static boolean isEmpty (String input) {
        return Pattern.matches(ValidationRegex.EMPTY_VALUE.get(), input);
    }

    public static boolean isNumber (String input) {
        return Pattern.matches(ValidationRegex.NUMBER.get(), input);
    }

    public static void validateNumberInput (String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.get());
        }

        if (!isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.get());
        }
    }

    public static void validatePanelInput (String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.get());
        }

        if (!isValidPanel(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PANEL.get());
        }
    }

    private static boolean isValidPanel (String input) {
        return Pattern.matches(ValidationRegex.VALID_PANEL.get(), input);
    }

    public static void validateRetryOptionInput (String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.get());
        }

        if (!isValidRetryOption(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_OPTION.get());
        }
    }

    private static boolean isValidRetryOption (String input) {
        return Pattern.matches(ValidationRegex.VALID_RETRY_OPTION.get(), input);
    }
}
