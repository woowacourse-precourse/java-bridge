package bridge.constant.command;

public enum Command {
    POSSIBLE("O"),
    IMPOSSIBLE("X"),
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
