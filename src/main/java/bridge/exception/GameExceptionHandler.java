package bridge.exception;

public class GameExceptionHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private static GameExceptionHandler instance;

    private GameExceptionHandler() {

    }

    public static GameExceptionHandler getGameExceptionHandler() {
        if (instance == null) {
            instance = new GameExceptionHandler();
        }
        return instance;
    }

    public void handleIllegalArgumentException(IllegalArgumentException exception) {
        System.out.println(ERROR_PREFIX + exception.getMessage());
    }
}
