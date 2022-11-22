package bridge.enums;

public enum MovingDirection {
    UPPER("U", 1),
    LOWER("D", 0);

    private final String direction;
    private final int value;

    MovingDirection(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }
    public int getValue() { return value;}
}
