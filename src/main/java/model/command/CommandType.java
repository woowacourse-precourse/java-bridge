package model.command;

import model.TypeCheck;

import java.util.Arrays;

public enum CommandType implements TypeCheck {

    R(true),
    Q(false);

    private static final String VALUE_ERROR = String.format("%s 또는 %s가 아닙니다.", R, Q);
    private final boolean run;

    CommandType(boolean run) {
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }

    public static Boolean isRetry(String command) {
        return Arrays.stream(values())
                .filter(type -> type.isEqualsMark(command))
                .findAny()
                .map(CommandType::isRun)
                .orElseThrow(() -> new IllegalArgumentException(VALUE_ERROR));
    }

    @Override
    public boolean isEqualsMark(String mark) {
        return this.toString().equals(mark);
    }
}
