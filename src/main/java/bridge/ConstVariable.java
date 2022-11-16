package bridge;

public enum ConstVariable {
    MIN_BRIDGE_LENGTH(3), MAX_BRIDGE_LENGTH(20);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
