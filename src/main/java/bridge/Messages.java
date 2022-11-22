package bridge;

public enum Messages {

    INVALID_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자로 입력해주세요."),
    INVALID_COMMAND("[ERROR] 게임 다시 시도 여부는 R(재시도)과 Q(종료) 중 하나의 문자로 입력해주세요."),
    ;

    private final String errorMsg;

    Messages(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
