package bridge.exception.domain;

import bridge.exception.BridgeException;

public class TryCountRangeException extends BridgeException {
    private static final String TRY_COUNT_RANGE_EXCEPTION_MESSAGE = "시도 횟수는 %s 부터 %s까지 입니다.";

    public TryCountRangeException(int tryCountStart, int tryCountMax) {
        super(String.format(TRY_COUNT_RANGE_EXCEPTION_MESSAGE, tryCountStart, tryCountMax));
    }
}
