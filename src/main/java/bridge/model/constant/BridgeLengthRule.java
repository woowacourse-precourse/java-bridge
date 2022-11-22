package bridge.model.constant;

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

    public static void validLength(int length) {
        if (length < MIN_LENGTH.getValue() || length > MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하여야 합니다!");
        }
    }
}
