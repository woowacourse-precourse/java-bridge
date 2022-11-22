package bridge.model.constant;

public enum BridgeSpace {

    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String value;

    BridgeSpace(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BridgeSpace get(int number) {
        if (number == UP.number) {
            return UP;
        }
        if (number == DOWN.number) {
            return DOWN;
        }
        throw new IllegalStateException();
    }
}
