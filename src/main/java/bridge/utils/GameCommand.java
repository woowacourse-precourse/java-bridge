package bridge.utils;

public enum GameCommand {
    END("Q"),
    RESTART("R");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
