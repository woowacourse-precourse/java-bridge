package bridge.constant;

public enum Command {
    MOVE_UP("U"),
    MOVE_DOWN("D"),
    DO_RETRY("R"),
    DO_QUIT("Q");

    private final String command;

    Command(String command) { this.command = command; }

    public String getCommand() {
        return command;
    }
}
