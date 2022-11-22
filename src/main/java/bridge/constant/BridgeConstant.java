package bridge.constant;

public enum BridgeConstant {
    BRIDGE_SIZE_START_INCLUSIVE(3),
    BRIDGE_SIZE_END_INCLUSIVE(20);

    private final int value;

    BridgeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
