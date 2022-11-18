package bridge.domain;

import bridge.constant.Constant;

import java.util.Arrays;

public enum Direction {
    UP(1, Constant.UP),
    DOWN(0, Constant.DOWN);

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
