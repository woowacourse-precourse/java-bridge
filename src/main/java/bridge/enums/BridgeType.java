package bridge.enums;


public enum BridgeType {
    UP("U", 1), DOWN("D", 0);

    private final String command;
    private final int value;

    BridgeType(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public int getValue() {
        return value;
    }
}