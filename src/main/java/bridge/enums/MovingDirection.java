package bridge.enums;

public enum MovingDirection {
    Upper("U"),
    Lower("D");

    private final String direction;

    MovingDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
