package bridge.domain.bridgeenum;

public enum BridgeCondition {
    MIN(3),
    MAX(20);

    private final int value;

    BridgeCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
