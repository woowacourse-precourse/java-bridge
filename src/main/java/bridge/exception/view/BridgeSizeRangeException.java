package bridge.exception.view;

import bridge.exception.BridgeException;

public class BridgeSizeRangeException extends BridgeException {
    private static final String BRIDGE_SIZE_RANGE_EXCEPTION_MESSAGE = "%s 이상 %s 이하의 숫자를 입력할 수 있습니다.";

    public BridgeSizeRangeException(int bridgeSizeMin, int bridgeSizeMax) {
        super(String.format(BRIDGE_SIZE_RANGE_EXCEPTION_MESSAGE, bridgeSizeMin, bridgeSizeMax));
    }
}
