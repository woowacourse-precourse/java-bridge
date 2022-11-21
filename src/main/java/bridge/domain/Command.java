package bridge.domain;

import java.util.Arrays;

public enum Command {
    Restart("R"),
    Quit("Q");

    private static final String INVALID_STRING_ERROR_MESSAGE = "[ERROR] 유효하지 않은 게임 진행 Command입니다.";

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command getCommandByString(String commandData) {
        return Arrays.stream(Command.values())
                .filter((ch) -> ch.command.equals(commandData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_STRING_ERROR_MESSAGE));
    }
}
