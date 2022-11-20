package bridge.domain.bridgeenum;

public enum BridgeSize {
    MIN(3),
    MAX(20);

    private final int value;

    BridgeSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
