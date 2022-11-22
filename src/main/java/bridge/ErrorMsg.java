package bridge;

public enum ErrorMsg {
    PREFIX("[ERROR] "),

    INVALID_INT_RANGE("잘못된 범위의 숫자 입니다"),
    NOT_A_NUMBER("숫자를 입력해주세요"),
    INVALID_DIR("잘못된 방향입니다"),
    INVALID_COMMEND("잘못된 명령입니다");

    final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
