package model;

import java.util.Arrays;

public enum GameResult {
    SUCCESS(true, "O"),
    FAIL(false, "X"),
    NONE(null, " ");

    private final Boolean move;
    private final String mark;

    GameResult(Boolean move, String mark) {
        this.move = move;
        this.mark = mark;
    }
    public Boolean getMove() {
        return move;
    }

    public static GameResult getByBoolean(boolean move) {
        return Arrays.stream(values())
                .filter(type -> type.move == move)
                .findAny()
                .orElse(NONE);
    }
}
