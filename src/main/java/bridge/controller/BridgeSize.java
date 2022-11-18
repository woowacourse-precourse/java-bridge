package bridge.controller;

public enum BridgeSize {
    MINIMUM(3),
    MAXIMUM(20);

    private final int size;

    BridgeSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
