package bridge.utils.enums;

public enum BridgeRule {
    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private final int value;

    BridgeRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
