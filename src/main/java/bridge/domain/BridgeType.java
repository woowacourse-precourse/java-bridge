package bridge.domain;

public enum BridgeType {
    U(1),
    D(0),
    UNKNOWN(-1);

    private final int value;

    BridgeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
