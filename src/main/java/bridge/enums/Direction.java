package bridge.enums;

/**
 * 사용자의 입력방향을 나타낸다.
 */
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

    public static Direction getEnum(String inputDirection) {
        for (Direction direction : Direction.values()) {
            if (direction.getDirection().equals(inputDirection)) {
                return direction;
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
