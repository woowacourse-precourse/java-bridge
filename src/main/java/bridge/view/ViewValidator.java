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
}
