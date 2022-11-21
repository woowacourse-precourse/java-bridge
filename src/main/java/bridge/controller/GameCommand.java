package bridge.controller;

import java.util.Arrays;
import java.util.Objects;

public enum GameCommand {
    RESTART ("R"),
    QUIT ("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static GameCommand parseCommandToInstance(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(game -> Objects.equals(game.getCommand(), command))
                .findFirst()
                .orElseThrow();
    }
}
