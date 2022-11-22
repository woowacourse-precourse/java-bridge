package bridge.domain.constants;


public enum Command {
    MOVE_UP("U"),
    MOVE_DOWN("D"),
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
