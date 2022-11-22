package bridge.domain;

import java.util.Arrays;

public enum Direction {
    LOWER(0, "D"),
    UPPER(1, "U");

    private final int value;
    private final String direction;

    Direction(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public static Direction getDirectionByValue(int randomValue) {
        return Arrays.stream(Direction.values())
                .filter(values -> values.value == randomValue)
                .findAny()
                .orElse(null);
    }

    public static Direction getDirection(String inputDirection) {
        return Arrays.stream(Direction.values())
                .filter(values -> values.direction.equals(inputDirection))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return direction;
    }
}
