package bridge.exception;

public class ExceptionPrinter {
    public static void printException(ExceptionMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printAndThrowException(ExceptionMessage message) {
        printException(message);
        throw new IllegalArgumentException(message.getMessage());
    }
}
