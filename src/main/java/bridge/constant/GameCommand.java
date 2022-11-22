package bridge.constant;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R", true),
    QUIT("Q", false);

    private final String command;
    private final boolean restart;

    GameCommand(String command, boolean restart) {
        this.command = command;
        this.restart = restart;
    }

    public static GameCommand fromCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command == command)
                .findAny()
                .get();
    }

    public boolean isRestart() {
        return restart;
    }

    public String getCommand() {
        return command;
    }
}
