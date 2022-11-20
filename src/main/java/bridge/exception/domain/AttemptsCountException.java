package bridge.exception.domain;

import bridge.exception.BridgeException;

public class AttemptsCountException extends BridgeException {
    private static final String ATTEMPTS_COUNT_EXCEPTION_MESSAGE = "시도 횟수는 다리 길이를 넘을 수 없습니다.";

    public AttemptsCountException() {
        super(ATTEMPTS_COUNT_EXCEPTION_MESSAGE);
    }
}
