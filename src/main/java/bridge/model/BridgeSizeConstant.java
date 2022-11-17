package bridge.model;

public enum BridgeSizeConstant {
    INPUT_LENGTH(2),
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
