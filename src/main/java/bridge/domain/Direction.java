package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final int value;
    private final String mark;

    Direction(int value, String mark) {
        this.value = value;
        this.mark = mark;
    }

    private int getValue() {
        return value;
    }

    private String getMark() {
        return mark;
    }

    public static String findMark(int randomValue) {
        return Arrays.stream(Direction.values())
                .filter(status -> status.getValue() == randomValue)
                .findAny()
                .get().getMark();
    }
}
