package bridge.constant;

public enum BridgeRule {

    MINIMUM_SIZE(3),
    MAXIMUM_SIZE(20);

    private final int size;

    BridgeRule(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
