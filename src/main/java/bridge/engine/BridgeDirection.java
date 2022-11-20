package bridge.engine;

public enum BridgeDirection {

    U(1),
    D(0)
    ;

    private int value;

    BridgeDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isMatch(String target) {
        for (BridgeDirection direction : BridgeDirection.values()) {
            if (direction.name().equals(target)) {
                return true;
            }
        }

        return false;
    }

    public static BridgeDirection match(int value) {
        for (BridgeDirection direction : BridgeDirection.values()) {
            if (direction.getValue() == value) {
                return direction;
            }
        }

        return U;
    }
}
