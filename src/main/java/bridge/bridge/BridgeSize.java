package bridge.bridge;

import java.util.NoSuchElementException;

public class BridgeSize {
    private static final String BRIDGE_SIZE_RANGE_EXCEPTION = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String BRIDGE_SIZE_NUMERIC_EXCEPTION = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        bridgeNumericException(bridgeSize);
        bridgeSizeRangeException(bridgeSize);
        this.bridgeSize = toInteger(bridgeSize);
    }

    private Integer toInteger(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

    private void bridgeSizeRangeException(String bridgeSize) {
        if ((toInteger(bridgeSize) < 3) || (toInteger(bridgeSize) > 20 )) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_EXCEPTION);
        }
    }

    private void bridgeNumericException(String bridgeSize) {
        try {
            toInteger(bridgeSize);
        } catch (NumberFormatException ignore) {
            System.out.println(BRIDGE_SIZE_NUMERIC_EXCEPTION);
            throw new NoSuchElementException();
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
