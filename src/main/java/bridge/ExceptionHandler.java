package bridge;

import bridge.data.Error;

public class ExceptionHandler {

    public static void checkNullInput(String input) throws IllegalArgumentException {
        if (input.length() <= 0) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }
}
