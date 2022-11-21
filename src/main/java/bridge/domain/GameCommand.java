package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand findByCommand(String command){
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command == command)
                .findAny()
                .orElseThrow();
    }

    public String getCommand() {
        return this.command;
    }
}
