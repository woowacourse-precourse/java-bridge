package bridge.domain;

public enum Direction {
    MOVING_UP("U", 1),
    MOVING_DOWN("D", 0);

    private final String MovingDirection;
    private final int MovingNumber;

    Direction(String movingDirection, int movingNumber) {
        MovingDirection = movingDirection;
        MovingNumber = movingNumber;
    }
}
