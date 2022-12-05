package bridge.utils;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;

public class IntegerConvertor {
    public static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }
}
