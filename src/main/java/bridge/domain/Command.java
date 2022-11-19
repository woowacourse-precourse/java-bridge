package bridge.domain;

public enum Command {

    UP("U"),
    DOWN("D"),
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
