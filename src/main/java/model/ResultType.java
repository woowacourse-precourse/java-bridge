package model;

import java.util.Arrays;

public enum ResultType {
    WIN(true, "성공"),
    LOSE(false, "실패");

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
                .orElse(null);
    }
}
