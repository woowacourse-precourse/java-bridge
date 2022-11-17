package bridge.exception;

public enum ErrorMsg {
    WRONG_BRIDGE_SIZE("[ERROR] 다리의 크기는 3이상 20이하입니다.\n"),
    NOT_NUMBER("[ERROR] 숫자를 입력해주세요\n");

    private String msg;
    ErrorMsg(String msg){
        this.msg = msg;
    }
    public String toString(){
        return this.msg;
    }
}
