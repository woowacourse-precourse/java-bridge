package bridge;

public class GameExceptionHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void handleIllegalArgumentException(IllegalArgumentException exception) {
        System.out.println(ERROR_PREFIX + exception.getMessage());
    }
}
