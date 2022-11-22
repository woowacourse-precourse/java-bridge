package bridge.constant;

public enum BridgeLength {
    MIN(3),
    MAX(20);

    public static final String INVALID_BRIDGE_SIZE_INPUT_MSG =
            "유효하지 않은 다리 크기입니다. (" + MIN.length + "이상 " + MAX.length + "이하)";

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
