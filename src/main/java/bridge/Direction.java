package bridge;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
    UP("U"), DOWN("D");

    private final String value;
    static private final String invalidMoveDirectionMessage = "이동할 방향은 U 또는 D여야 합니다.";
    static private final String invalidNumberMessage = "값은 0과 1중 하나여야 합니다.";

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
        throw new IllegalArgumentException(invalidMoveDirectionMessage);
    }

    static public String getDirection(int number) {
        if (number == 1) {
            return UP.getValue();
        }
        if (number == 0) {
            return DOWN.getValue();
        }
        throw new IllegalArgumentException(invalidNumberMessage);
    }

    static public List<Direction> getDirections(List<String> values) {
        List<Direction> directions = new ArrayList<>();
        for (String value : values) {
            directions.add(getDirection(value));
        }
        return directions;
    }
}
