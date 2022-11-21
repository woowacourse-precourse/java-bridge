package model.game;

import java.util.Arrays;

import static constant.Config.ERROR;

public enum ResultType {
    WIN(true, "성공"),
    LOSE(false, "실패");

    private static final String VALUE_ERROR = ERROR + String.format("%s 또는 %s가 아닙니다.", WIN.run, LOSE.run);
    private final boolean run;
    private final String message;

    ResultType(Boolean run, String message) {
        this.run = run;
        this.message = message;
    }

    public boolean isRun() {
        return run;
    }

    public String getMessage() {
        return message;
    }

    public static ResultType getByBoolean(boolean run) {
        return Arrays.stream(values())
                .filter(type -> type.run == run)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(VALUE_ERROR));
    }
}
