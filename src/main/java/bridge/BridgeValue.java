package bridge;

public enum BridgeValue {
    LOWER_BRIDGE("D", 0),
    UPPER_BRIDGE("U", 1),
    ;

    private final String direction;
    private final int number;

    BridgeValue(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public String getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }
}