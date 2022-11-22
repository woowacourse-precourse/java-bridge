package bridge.Model;

public enum BridgeSize {
    MIN_SIZE(3), MAX_SIZE(20);

    private final int size;

    BridgeSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
