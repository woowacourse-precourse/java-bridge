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
}
