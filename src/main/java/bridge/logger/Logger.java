package bridge.logger;

import static bridge.logger.Level.DEBUG;
import static bridge.logger.Level.ERROR;

public interface Logger {

    static void debug(final String message) {
        logging(DEBUG, message);
    }

    static void debug(
            final String message,
            final int integer
    ) {
        logging(DEBUG, message, integer);
    }

    static void debug(
            final String message,
            final String string
    ) {
        logging(DEBUG, message, string);
    }

    static void error(final String message) {
        logging(ERROR, message);
    }

    static void error(
            final String message,
            final int integer
    ) {
        logging(ERROR, message, integer);
    }

    static void error(
            final String message,
            final String string
    ) {
        logging(ERROR, message, string);
    }

    private static void logging(
            final Level level,
            final String message
    ) {
        logging(String.format("[%s] %s", level, message));
    }

    private static void logging(
            final Level level,
            final String message,
            final int integer
    ) {
        logging(String.format("[%s] %s: %d", level, message, integer));
    }

    static void logging(
            final Level level,
            final String message,
            final String string)
    {
        logging(String.format("[%s] %s: ^%s$", level, message, string));
    }

    private static void logging(final String text) {
        System.out.println(text);
    }
}
