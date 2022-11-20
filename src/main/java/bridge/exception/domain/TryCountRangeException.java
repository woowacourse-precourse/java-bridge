package bridge.exception.domain;

import bridge.exception.BridgeException;

public class TryCountRangeException extends BridgeException {
    private static final String TRY_COUNT_RANGE_EXCEPTION_MESSAGE = "시도 횟수는 %s 부터 시작합니다.";

    public TryCountRangeException(int tryCountStart) {
        super(String.format(TRY_COUNT_RANGE_EXCEPTION_MESSAGE, tryCountStart));
    }
}
