package bridge.model;

public enum BridgeControlType {
    UP("U", 1),
    DOWN("D", 0),
    RETRY("R", 1),
    QUIT("Q", 0);

    private String command;
    private int status;

    BridgeControlType(String command, int status) {
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

