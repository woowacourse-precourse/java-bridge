package bridge.constant;

public enum BridgeLengthRule {
    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private final int value;

    BridgeLengthRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
