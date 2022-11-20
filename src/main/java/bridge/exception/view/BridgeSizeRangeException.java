package bridge.exception.view;

import bridge.exception.BridgeException;

public class BridgeSizeRangeException extends BridgeException {
    private static final String BRIDGE_SIZE_RANGE_EXCEPTION_MESSAGE = "다리 길이는 %s부터 %s 사이의 숫자여야 합니다.";

    public BridgeSizeRangeException(int bridgeSizeMin, int bridgeSizeMax) {
        super(String.format(BRIDGE_SIZE_RANGE_EXCEPTION_MESSAGE, bridgeSizeMin, bridgeSizeMax));
    }
}
