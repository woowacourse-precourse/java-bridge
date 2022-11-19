package bridge.domain;

public enum Direction {
    UPPER("U"),
    LOWER("D");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return this.getDirection();
    }
}
