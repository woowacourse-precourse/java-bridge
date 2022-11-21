package bridge.utils.command;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
