package bridge.utils.constants;

public enum Commons {

    MIN_BRIDGE_RANGE(3),
    MAX_BRIDGE_RANGE(20),
    BRIDGE_HEIGHT(2),
    INDEX_ZERO(0),
    INDEX_ONE(1),
    ;
    private final int number;

    Commons(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
