package bridge;

import bridge.exception.ExceptionHandler;
import bridge.exception.ExceptionMessage;

public class Validator {
    public static <T> void validateNotNull(T object) {
        if (object == null) {
            ExceptionHandler.throwException(
                    new IllegalArgumentException(),
                    ExceptionMessage.NULL
            );
        }
    }

    public static void validateNotEmpty(String string) {
        if (string.equals("")) {
            ExceptionHandler.throwException(
                    new IllegalArgumentException(),
                    ExceptionMessage.EMPTY_STRING
            );
        }
    }

    public static <T> void validateInteger(T input) {
        try {
            Integer.parseInt((String) input);
        } catch (NumberFormatException e) {
            ExceptionHandler.throwException(
                    new IllegalArgumentException(),
                    ExceptionMessage.INTEGER_TYPE_MISMATCH
            );
        }
    }
}
