package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String initial;

    Direction(int number, String initial) {
        this.number = number;
        this.initial = initial;
    }

    public static String getInitialByDirectionNumber(int directionNumber) {
        return Arrays.stream(values())
                .filter(direction -> direction.number == directionNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .initial;
    }
}
