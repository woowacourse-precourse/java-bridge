package bridge.exception;

public enum ErrorMsg {
    WRONG_BRIDGE_SIZE("[ERROR] 다리의 크기는 3이상 20이하입니다.\n"),
    NOT_ALLOWED_MOVEMENT("[ERROR] 이동은 U, D만 입력 가능합니다."),
    NOT_ALLOWED_COMMAND("[ERROR] R, Q만 입력 가능합니다.");

    private String msg;
    ErrorMsg(String msg){
        this.msg = msg;
    }
    public String toString(){
        return this.msg;
    }
}
