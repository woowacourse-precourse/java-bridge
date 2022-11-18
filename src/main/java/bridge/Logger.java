package bridge;

public class Logger {

    private static final String ERROR_LOG_PREFIX = "[ERROR] ";

    private Logger() {
    }

    public void printError(String errorMessage) {
        System.out.println(ERROR_LOG_PREFIX + errorMessage);
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }
}
