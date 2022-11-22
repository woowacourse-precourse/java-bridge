package bridge.enums;

public enum MovingDirection {
    UPPER("U"),
    LOWER("D");

    private final String direction;

    MovingDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
