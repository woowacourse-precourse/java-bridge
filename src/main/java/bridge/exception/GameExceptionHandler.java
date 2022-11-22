package bridge.exception;

public class GameExceptionHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final int SERIAL_EXCEPTION_THRESHOLD = 5;
    private static final String THRESHOLD_EXCEEDED = "연속된 예외 횟수가 허용치를 초과하여 프로그램이 종료되었습니다.";

    private static GameExceptionHandler instance;

    private int numSerialExceptions;

    private GameExceptionHandler() {
        this.numSerialExceptions = 0;
    }

    public static GameExceptionHandler getGameExceptionHandler() {
        if (instance == null) {
            instance = new GameExceptionHandler();
        }
        return instance;
    }

    public void handleIllegalArgumentException(IllegalArgumentException exception) {
        System.out.println(ERROR_PREFIX + exception.getMessage());
        this.numSerialExceptions++;
        throwExceptionToMainIfExceedsThreshold();
    }

    private void throwExceptionToMainIfExceedsThreshold() throws IllegalArgumentException {
        if (SERIAL_EXCEPTION_THRESHOLD < this.numSerialExceptions) {
            throw new IllegalArgumentException(ERROR_PREFIX + THRESHOLD_EXCEEDED);
        }
    }
}
