package bridge.constant;

import java.util.Arrays;

public enum Direction {
    UPPER(0, "U"),
    LOWER(1, "D");

    private final int value;
    private final String direction;

    Direction(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public static Direction getDirection(int randomValue) {
        return Arrays.stream(Direction.values())
                .filter(values -> values.value == randomValue)
                .findAny()
                .orElse(null);
    }
}
