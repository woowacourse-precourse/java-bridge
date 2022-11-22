package bridge.exception;

public class BridgeSizeOutOfRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public BridgeSizeOutOfRangeException() {
        super(ERROR_MESSAGE);
    }
}
