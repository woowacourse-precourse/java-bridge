package bridge;

public enum Commands {

    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
