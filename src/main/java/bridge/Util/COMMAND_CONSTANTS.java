package bridge.Util;

public enum COMMAND_CONSTANTS {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0),
    RETRY("R", 2),
    QUIT("Q", 3),
    FINISH("FIN", 4),
    CORRECT("COR", 0),
    WRONG("WRN", 5);

    private String commnad;
    private int value;

    COMMAND_CONSTANTS(String command, int value) {
        this.commnad = command;
        this.value = value;
    }

    public String getCommnad() {
        return commnad;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
