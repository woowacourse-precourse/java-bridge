package bridge.value;

public enum BridgeValue {
    LOCATION_INIT(0),
    LOCATION_INCREMENT(1),
    SIZE_START_RANGE(3),
    SIZE_END_RANGE(20);
    private final int value;

    BridgeValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
