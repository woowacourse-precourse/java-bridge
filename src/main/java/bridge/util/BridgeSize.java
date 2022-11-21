package bridge.util;

public enum BridgeSize {
    BRIDGE_MIN_SIZE(3),
    BRIDGE_MAX_SIZE(20);

    private final int size;

    BridgeSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
