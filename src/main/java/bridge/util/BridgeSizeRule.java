package bridge.util;

public enum BridgeSizeRule {
    BRIDGE_MIN_SIZE(3), BRIDGE_MAX_SIZE(20);
    private int size;
    BridgeSizeRule(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
