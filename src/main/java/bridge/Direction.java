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

    /**
     * 문자열로 된 방향을 Direction으로 변환한다.
     * 
     * @param value
     * @return Direction
     */
    static public Direction getDirection(String value) {
        for (Direction direction : Direction.values()) {
            if (direction.getValue().equals(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException(invalidMoveDirectionMessage);
    }

    /**
     * 숫자로 된 방향을 Direction으로 변환한다.
     * 
     * @param number
     * @return Direction
     */
    static public String getDirection(int number) {
        if (number == 1) {
            return UP.getValue();
        }
        if (number == 0) {
            return DOWN.getValue();
        }
        throw new IllegalArgumentException(invalidNumberMessage);
    }

    /**
     * 문자열 리스트로된 다리를 Direction 리스트로 변환한다.
     * 
     * @param values 문자열 리스트
     * @return Direction 리스트
     */
    static public List<Direction> getDirections(List<String> values) {
        List<Direction> directions = new ArrayList<>();
        for (String value : values) {
            directions.add(getDirection(value));
        }
        return directions;
    }
}
