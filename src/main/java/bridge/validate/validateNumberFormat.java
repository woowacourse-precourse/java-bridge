package bridge.validate;

import bridge.exception.InvalidNumberFormatException;

import java.util.regex.Pattern;

public class validateNumberFormat {
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public static void validate(String inputValue) {
        if (PATTERN.matcher(inputValue).matches()) {
            return;
        }

        throw new InvalidNumberFormatException();
    }
}
