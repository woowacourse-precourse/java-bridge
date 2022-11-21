package model;

import java.util.Arrays;

public enum MapType {
    SUCCESS(true, "O"),
    FAIL(false, "X"),
    NONE(null, " ");

    private final Boolean move;
    private final String mark;

    MapType(Boolean move, String mark) {
        this.move = move;
        this.mark = mark;
    }

    public Boolean canMove() {
        return move;
    }

    public String getMark() {
        return mark;
    }

    public static String getMarkByBoolean(Boolean move) {
        return Arrays.stream(values())
                .filter(type -> type.move == move)
                .findAny()
                .map(MapType::getMark)
                .orElse(NONE.getMark());
    }
}
