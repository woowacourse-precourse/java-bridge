package bridge.enums;

public enum Direction {
    DOWNWARD_DIRECTION(0, "D"),
    UPWARD_DIRECTION(1, "U"),
    ;

    private final int value;
    private final String direction;

    Direction(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public static String getDirection(int value) {
        for (Direction direction : Direction.values()) {
            if (direction.getValue() == value) {
                return direction.getDirection();
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getDirection() {
        return direction;
    }
}
