package bridge.model;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String direction;
    private final int directionNumber;

    Direction(String direction, int directionNumber) {
        this.direction = direction;
        this.directionNumber = directionNumber;
    }

    public boolean isSame(int directionNumber) {
        return this.directionNumber == directionNumber;
    }

    public boolean isSame(String direction) {
        return this.direction.equals(direction);
    }

    public String getDirection() {
        return direction;
    }
}
