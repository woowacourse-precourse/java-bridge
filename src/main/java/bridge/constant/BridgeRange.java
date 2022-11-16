package bridge.constant;

public enum BridgeRange {

    MIN(3),
    MAX(20);

    private final int value;

    BridgeRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
