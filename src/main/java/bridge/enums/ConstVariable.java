package bridge.enums;

public enum ConstVariable {
    MIN_BRIDGE_LENGTH(3), MAX_BRIDGE_LENGTH(20);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isLowerThanMinBridgeLength(int length) {
        return MIN_BRIDGE_LENGTH.getValue() > length;
    }

    public static boolean isGreaterThanMaxBridgeLength(int length) {
        return MAX_BRIDGE_LENGTH.getValue() < length;
    }
}
