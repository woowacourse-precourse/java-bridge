package bridge.exception;

public class BridgeRangeException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_BRIDGE_RANGE = "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.";

    public BridgeRangeException(int min, int max) {
        super(String.format(EXCEPTION_MESSAGE_BRIDGE_RANGE, min, max));
    }
}
