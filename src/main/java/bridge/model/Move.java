package bridge.model;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);
    private final String command;
    private final int status;

    Move(String command, int status) {
        this.command = command;
        this.status = status;
    }

    public String getCommand() {
        return command;
    }

    public int getStatus() {
        return status;
    }
}
