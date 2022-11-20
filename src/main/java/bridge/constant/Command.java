package bridge.constant;

public enum Command {

    DO_RETRY("R"),
    DO_QUIT("Q");

    private final String command;

    Command(String command) { this.command = command; }

    public String getCommand() {
        return command;
    }
}
