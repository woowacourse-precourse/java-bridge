package bridge.exceptions;

import java.text.MessageFormat;

public interface CustomExceptionMessageFormat {
    public static String DEFAULT_MESSAGE = "[ERROR] {0}";

    public static String apply(String message) {
        return MessageFormat.format(DEFAULT_MESSAGE, message);
    }
}
