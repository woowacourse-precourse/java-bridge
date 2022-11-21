package bridge.model;

import bridge.constant.ErrorMessage;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String input) {
        return Arrays.stream(values())
                .filter(command -> command.isSameWith(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND_INPUT));
    }

    private boolean isSameWith(String command) {
        return this.command.equals(command);
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
