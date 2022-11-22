package bridge.model;

public enum BridgeStatus {
    UP("U", 1),
    DOWN("D", 0);

    private String command;
    private int status;

    BridgeStatus(String command, int status) {
        this.command = command;
        this.status = status;
    }

    public String getCommand() {
        return command;
    }

    public int getStatus() {
        return status;
    }

    public static BridgeStatus get(int status) {
        if (status == UP.getStatus()) {
            return UP;
        }
        return DOWN;
    }
}

