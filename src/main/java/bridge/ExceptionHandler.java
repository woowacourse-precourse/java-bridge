package bridge;

import bridge.data.Error;

public class ExceptionHandler {

    public static void checkNullInput(String input) throws IllegalArgumentException {
        if (input.length() <= 0) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    public static void checkIsNumber(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }
}
