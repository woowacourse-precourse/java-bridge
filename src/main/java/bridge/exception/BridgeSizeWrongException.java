package bridge.exception;

public class BridgeSizeWrongException extends IllegalArgumentException{
    private static final String WRONG_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.";

    public BridgeSizeWrongException() {
        super(WRONG_BRIDGE_SIZE_MESSAGE);
    }
}
