package bridge.model.constant;

public enum BridgeStatistic {
    LOWER_BOUND(3),
    UPPER_BOUND(20);

    private final int value;

    BridgeStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
