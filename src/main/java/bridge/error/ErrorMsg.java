package bridge.error;

public enum ErrorMsg {
    ERR("[ERROR] "),
    BRIDGE_LENGTH_ERR(ERR + "3이상 20이하의 숫자를 입력해주세요."),
    MOVE_ERR(ERR + "U나 D 둘 중 하나를 입력해주세요."),
    RESTART_ERR(ERR + "R이나 Q 둘 중 하나를 입력해주세요");

    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }
}
