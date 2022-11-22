package bridge.validate;

import bridge.exception.InvalidStringFormatException;

import java.util.regex.Pattern;

public class ValidateStringFormat {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]+");

    public static void validate(String inputValue) {
        if (PATTERN.matcher(inputValue).matches()) {
            return;
        }

        throw new InvalidStringFormatException();
    }
}
