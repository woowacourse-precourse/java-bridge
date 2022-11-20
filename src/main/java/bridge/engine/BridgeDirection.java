package bridge.engine;

public enum BridgeDirection {

    U(1),
    D(0)
    ;

    private int value;

    BridgeDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
