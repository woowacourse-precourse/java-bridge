package bridge.model;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
