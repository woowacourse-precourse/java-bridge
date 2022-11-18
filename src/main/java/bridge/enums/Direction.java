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

    public int getValue() {
        return value;
    }

    public String getDirection() {
        return direction;
    }
}
