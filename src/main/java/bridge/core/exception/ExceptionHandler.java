package bridge.core.exception;

public class ExceptionHandler {

    public static void handle(InvalidInputException error) {
        System.out.println(error.getMessage());
        System.out.println();
    }
}
