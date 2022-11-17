package bridge.msg;

public enum InputMsg {
    RESTART_MSG("R"),
    QUIT_MSG("Q"),
    UP_MSG("U"),
    DOWN_MSG("D"),
    ENABLE_MSG("O"),
    UNABLE_MSG("X");

    private String msg;

    InputMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
