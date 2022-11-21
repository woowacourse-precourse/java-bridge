package bridge;

public enum RestartCommand {
    RESTART("R"),
    QUIT("Q");
    private final String command;

    RestartCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
