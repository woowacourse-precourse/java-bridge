package bridge.view;

public class ErrorView {

    private static final String ERROR_FORMAT = "%s%s%s";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printException(final IllegalArgumentException illegalArgumentException) {
        System.out.printf(ERROR_FORMAT, ERROR_PREFIX, illegalArgumentException.getMessage(), System.lineSeparator());
    }
}
