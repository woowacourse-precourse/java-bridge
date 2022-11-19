package bridge.model;

import static bridge.exception.ExceptionMessages.InvalidGameCommand;

import java.util.Arrays;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand fromCommand(String command) {
        return Arrays.stream(GameCommand.values())
            .filter(gameCommand -> gameCommand.hasCommand(command))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(InvalidGameCommand));
    }

    public boolean hasCommand(String command) {
        return this.command.equals(command);
    }
}
