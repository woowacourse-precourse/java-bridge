package bridge.utils;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void print(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
