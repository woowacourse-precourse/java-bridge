package bridge;

public enum Direction {
    U(1),
    D(0);

    private final int directionValue;

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
}
