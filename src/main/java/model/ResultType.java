package model;

import java.util.Arrays;

public enum ResultType {
    SUCCESS(true, "O"),
    FAIL(false, "X"),
    NONE(null, " ");

    private final Boolean move;
    private final String mark;

    ResultType(Boolean move, String mark) {
        this.move = move;
        this.mark = mark;
    }

    public static ResultType getByBoolean(Boolean move) {
    public static String getMarkByBoolean(Boolean move) {
        return Arrays.stream(values())
                .filter(type -> type.move == move)
                .findAny()
                .map(ResultType::getMark)
                .orElse(NONE.getMark());
    }
}
