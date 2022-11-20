package bridge.domain;

public enum BrideLength {
    MIN(3),
    MAX(20);

    private final int size;

    BrideLength(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
