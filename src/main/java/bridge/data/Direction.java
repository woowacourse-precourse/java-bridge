package bridge.data;

public enum Direction {
    UP_DIRECTION(0),
    DOWN_DIRECTION(1);
    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
