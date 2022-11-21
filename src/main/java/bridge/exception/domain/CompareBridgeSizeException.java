package bridge.exception.domain;

import bridge.exception.BridgeException;

public class CompareBridgeSizeException extends BridgeException {
    private static final String ATTEMPTS_COUNT_EXCEPTION_MESSAGE = "비교할 다리의 길이는 원본 다리의 길이를 넘을 수 없습니다.";

    public CompareBridgeSizeException() {
        super(ATTEMPTS_COUNT_EXCEPTION_MESSAGE);
    }
}
