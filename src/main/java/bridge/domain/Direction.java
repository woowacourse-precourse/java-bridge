package bridge.domain;

import bridge.constant.Constant;

import java.util.Arrays;

public enum Direction {
    UP(1, Constant.UP),
    DOWN(0, Constant.DOWN);

    private final int code;
    private final String mark;

    Direction(int code, String mark) {
        this.code = code;
        this.mark = mark;
    }

    private int getCode() {
        return code;
    }

    private String getMark() {
        return mark;
    }

    public static String findByCode(int randomValue) {
        return Arrays.stream(Direction.values())
                .filter(code -> code.getCode() == randomValue)
                .findAny()
                .get().getMark();
    }
}
