package bridge.util.constants;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;
    GameCommand(String command) {
        this.command = command;
    }

    public String command() {
        return command;
    }
}
