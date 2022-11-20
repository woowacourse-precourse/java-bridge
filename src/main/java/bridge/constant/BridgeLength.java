package bridge.constant;

public enum BridgeLength {
    MIN(3),
    MAX(20);

    public static boolean isInRange(int bridgeLength) {
        return MIN.length <= bridgeLength && bridgeLength <= MAX.length;
    }

    private final int length;

    BridgeLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}
