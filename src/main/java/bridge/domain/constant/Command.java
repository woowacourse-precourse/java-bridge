package bridge.domain.constant;

public enum Command {
    UPPER("U"),
    LOWER("D"),
    RETRY("R"),
    QUIT("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return this.getCommand();
    }
}
