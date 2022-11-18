package bridge.constants;

public enum MovingDirection {
    UP("U"),
    DOWN("D");

    private final String direction;

    MovingDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }
}
