package bridge.util;

public class Log {

    private static String ERROR_HEADER = "[ERROR] ";

    public static void error(String message) {
        System.out.println(ERROR_HEADER + message);
    }
}
