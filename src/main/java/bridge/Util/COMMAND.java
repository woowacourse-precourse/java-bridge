package bridge.Util;

public enum COMMAND {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0),
    RETRY("ds", 2),
    QUIT("e", 3);

    private String commnad;
    private int value;

    COMMAND(String command, int value){
        this.commnad = command;
        this.value = value;
    }
}
