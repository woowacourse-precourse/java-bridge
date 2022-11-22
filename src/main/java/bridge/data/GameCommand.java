package bridge.data;

public enum GameCommand {
    UP("U"),
    DOWN("D"),
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
