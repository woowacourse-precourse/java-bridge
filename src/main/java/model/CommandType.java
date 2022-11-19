package model;

import java.util.Arrays;

public enum CommandType {
    RETRY(true, "R"),
    QUIT(false, "Q");

    private final boolean run;
    private final String mark;

    CommandType(boolean run, String mark) {
        this.run = run;
        this.mark = mark;
    }

    public boolean isRun() {
        return run;
    }

    public String getMark() {
        return mark;
    }

    public boolean isEqualsMark(String mark) {
        return this.mark.equals(mark);
    }

    public static Boolean isRetry(String command) {
        return Arrays.stream(values())
                .filter(type -> type.mark.equals(command))
                .findAny()
                .map(CommandType::isRun)
                .orElse(null);
    }
}
