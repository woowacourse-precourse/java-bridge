package bridge.util.constants;

public enum BridgeConstant {
    MIN_BRIDGE_SIZE(3),
    MAX_BRIDGE_SIZE(20),
    UPPER_BRIDGE_NUMBER(1),
    LOWER_BRIDGE_NUMBER(0);

    private int value;
    BridgeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
