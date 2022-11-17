package bridge.constant;

public enum Constant {
    BRIDGE_MIN_SIZE(3),
    BRIDGE_MAX_SIZE(20);

    final private int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
