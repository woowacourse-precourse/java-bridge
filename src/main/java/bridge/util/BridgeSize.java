package bridge.util;

public enum BridgeSize {
    MINIMUM(3),
    MAXIMUM(20);

    private int size;
    BridgeSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static int findByRange(int bridgeSize) {
        if (!isRangeSize(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_RANGE_SIZE);
        }
        return bridgeSize;
    }

    public static boolean isRangeSize(int number) {
        return MINIMUM.size <= number && number <= MAXIMUM.size;
    }
}
