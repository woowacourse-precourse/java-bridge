package bridge.infrastructure;

import bridge.application.log.Logger;

import static java.lang.String.format;

public class ConsoleLogger implements Logger {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String ERROR_FORMAT = "%s %s";

    @Override
    public void error(final String message) {
        String format = format(ERROR_FORMAT, ERROR_PREFIX, message);
        System.out.println(format);
    }
}
