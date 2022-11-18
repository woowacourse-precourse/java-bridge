package bridge;

public class Logger {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static void log(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
