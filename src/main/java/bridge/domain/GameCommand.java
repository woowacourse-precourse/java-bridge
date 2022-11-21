package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    END("Q"),
    RESTART("R");

    private final String gameCommand;

    GameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public static GameCommand makeGameCommand(String userGameCommand) {
        GameCommand command = Arrays.stream(values())
                .filter(value -> value.gameCommand.equals(userGameCommand))
                .findAny()
                .orElse(null);
        return command;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
