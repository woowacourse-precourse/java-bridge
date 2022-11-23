package bridge.domain;

import java.util.Arrays;

import static bridge.support.ErrorMessage.INVALID_COMMAND_ERROR;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String code;

    Command(String code) {
        this.code = code;
    }

    public static Command from(String code) {
        return Arrays.stream(Command.values())
                .filter(command -> code.equals(command.code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_ERROR));
    }

    public static void validateGameCommand(String code) {
        from(code);
    }
}
