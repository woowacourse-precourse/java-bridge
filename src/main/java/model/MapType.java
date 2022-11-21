package model;

import java.util.Arrays;

public enum MapType {
    O(true),
    X(false);

    private static final String BLANK = " ";
    private final Boolean move;

    MapType(Boolean move) {
        this.move = move;
    }

    public static String getMarkByBoolean(Boolean move) {
        return Arrays.stream(values())
                .filter(type -> type.move == move)
                .findAny()
                .map(MapType::toString)
                .orElse(BLANK);
    }
}
