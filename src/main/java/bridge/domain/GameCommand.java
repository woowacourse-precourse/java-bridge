package bridge.domain;

import java.util.Arrays;

import static bridge.utils.ErrorMessages.ERROR_INVALID_GAME_COMMAND;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        return Arrays.stream(values())
                .filter(game -> game.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND));
    }

    public boolean isRetry() {
        return this == RETRY;
    }
}