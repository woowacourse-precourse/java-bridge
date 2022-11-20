package bridge.validate;

import bridge.exception.InvalidStringFormatException;

import java.util.regex.Pattern;

public class validateStringFormat {
    private static final Pattern PATTERN = Pattern.compile("[A-Z]+");

    public static void validate(String inputValue) {
        if (PATTERN.matcher(inputValue).matches()) {
            return;
        }

        throw new InvalidStringFormatException();
    }
}
