package bridge.enums;

public enum BridgeRange {
    MIN(3),
    MAX(20),
    EXCEPTION(-1);

    private final int range;

    BridgeRange(int range) {
        this.range = range;
    }

    public static boolean isWithinRange(int value) {
        if (value < MIN.range || MAX.range < value) {
            return false;
        }
        return true;
    }

    public static int getMinValue() {
        return MIN.range;
    }

    public static int getMaxValue() {
        return MAX.range;
    }

    public static int getExceptionValue() {
        return EXCEPTION.range;
    }
}
