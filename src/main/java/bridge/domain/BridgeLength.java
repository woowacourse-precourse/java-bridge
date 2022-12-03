package bridge.domain;

public enum BridgeLength {
    MIN(3),
    MAX(20);

    private final int size;

    BridgeLength(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
