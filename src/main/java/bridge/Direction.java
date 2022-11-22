package bridge;

public enum Direction {
    UP("U"), DOWN("D");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static public Direction getDirection(String value) {
        for (Direction direction : Direction.values()) {
            if (direction.getValue().equals(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("잘못된 방향 입력입니다.");
    }

    static public String getDirection(int number) {
        if (number == 1) {
            return UP.getValue();
        }
        if (number == 0) {
            return DOWN.getValue();
        }
        throw new IllegalArgumentException("값은 0과 1중 하나여야 합니다.");
    }
}
