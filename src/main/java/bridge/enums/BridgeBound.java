package bridge.enums;

public enum BridgeBound {
    BOUND_MIN(3),
    BOUND_MAX(20);

    private final int bound;

    BridgeBound(int bound) {
        this.bound = bound;
    }

    public int getBound() {
        return bound;
    }
}
