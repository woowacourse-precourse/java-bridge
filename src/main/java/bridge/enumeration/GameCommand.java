package bridge.enumeration;

public enum GameCommand {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
