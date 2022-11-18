package bridge;


import java.util.NoSuchElementException;

public class Bridge {
    private static final String BRIDGE_SIZE_RANGE_EXCEPTION = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String BRIDGE_SIZE_NUMERIC_EXCEPTION = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private final int bridgeSize;

    public Bridge(String bridgeSize) {
        bridgeNumericException(bridgeSize);
        bridgeSizeRangeException(bridgeSize);
        this.bridgeSize = getBridgeSize(bridgeSize);
    }

    public int getBridgeSize(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

    private void bridgeSizeRangeException(String bridgeSize) {
        if ((getBridgeSize(bridgeSize) < 3) || (getBridgeSize(bridgeSize) > 20 )) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_EXCEPTION);
        }
    }

    private void bridgeNumericException(String bridgeSize) {
        try {
            getBridgeSize(bridgeSize);
        } catch (NumberFormatException ignore) {
            System.out.println(BRIDGE_SIZE_NUMERIC_EXCEPTION);
            throw new NoSuchElementException();
        }
    }
}
