package bridge.enums;

public enum BridgeSizeBound {
    UPPER(20),
    LOWER(3);

    private final int bound;

    BridgeSizeBound(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }
}