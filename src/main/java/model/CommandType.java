package model;

import java.util.Arrays;

import static constant.Config.ERROR;

public enum CommandType {
    R(true),
    Q(false);

    private static final String VALUE_ERROR = ERROR + String.format("%s 또는 %s가 아닙니다.", R, Q);
    private final boolean run;

    CommandType(boolean run) {
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }

    public static Boolean isRetry(String command) {
        return Arrays.stream(values())
                .filter(type -> type.equals(valueOf(command)))
                .findAny()
                .map(CommandType::isRun)
                .orElseThrow(() -> new IllegalArgumentException(VALUE_ERROR));
    }

    public boolean isEqualsMark(String mark) {
        return this.equals(valueOf(mark));
    }
}
