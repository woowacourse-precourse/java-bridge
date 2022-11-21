package bridge;

public enum Direction {
    U(1), D(0);
    private int direction;
    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
