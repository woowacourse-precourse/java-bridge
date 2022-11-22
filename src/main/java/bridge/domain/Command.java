package bridge.domain;

public enum Command {
    UPPER("U"),
    LOWER("D"),
    RESTART("R"),
    QUIT("Q");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
