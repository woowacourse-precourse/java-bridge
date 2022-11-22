package bridge.Util;

public enum COMMAND_CONSTANTS {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0),
    CORRECT("COR", 0);

    private String command;
    private int value;

    COMMAND_CONSTANTS(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
