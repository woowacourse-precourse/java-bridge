package bridge.constant;

public enum BridgeProperties {
    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private final int property;

    private BridgeProperties (int property) {
        this.property = property;
    }

    public int get() {
        return property;
    }
}
