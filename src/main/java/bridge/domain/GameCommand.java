package bridge.domain;

import bridge.exception.domain.NoSuchGameCommandException;
import java.util.Arrays;

public enum GameCommand {
    RESTART("R"), QUIT("Q");

    private final String command;

    GameCommand(String gameCommand) {
        this.command = gameCommand;
    }

    public static GameCommand of(String text) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.command.equals(text))
                .findAny()
                .orElseThrow(() -> new NoSuchGameCommandException(text));
    }

    public boolean isRestart() {
        return this == GameCommand.RESTART;
    }
}
