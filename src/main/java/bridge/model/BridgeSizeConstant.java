package bridge.model;

public enum BridgeSizeConstant {
    LOWER_BOUND(3),
    UPPER_BOUND(20);

    private final int value;

    BridgeSizeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
