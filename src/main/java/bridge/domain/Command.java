package bridge.domain;

import bridge.util.ErrorMessage;
import java.util.Arrays;
import java.util.Objects;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private String code;

    Command(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Command toCommand(String label) {
        Command movement = findByCommand(label);
        if(Objects.isNull(movement)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_COMMAND_VALUE);
        }
        return movement;
    }

    private static Command findByCommand(String label) {
        return Arrays.stream(values())
                .filter(value -> value.code.equals(label))
                .findAny()
                .orElse(null);
    }
}
