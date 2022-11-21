package bridge;

public class BridgeSizeParameter {
    private static final int MIN = 3;
    private static final int MAX = 20;
    private int bridgeSize;

    public BridgeSizeParameter(int bridgeSize) {
        checkRange(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void checkRange(int bridgeSize) {
        if (bridgeSize < MIN || bridgeSize > MAX) {
            throw new BridgeSizeException("[ERROR] 최소보다 작거나 최대 입력 값보다 큽니다.");
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
