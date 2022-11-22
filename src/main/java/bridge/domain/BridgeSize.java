package bridge.domain;

public enum BridgeSize {
    SIZE_MINIMUM(3),
    SIZE_MAXIMUM(20);

    private final int size;

    BridgeSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
