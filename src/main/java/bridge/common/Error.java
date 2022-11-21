package bridge.common;

public enum Error {

    NOT_NUMBER("[ERROR] 숫자를 입력해주세요."),
    NOT_IN_RANGE("[ERROR] 3 이상 20 이하의 숫자를 입력해주세요."),
    NOT_BRIDGE_COMMAND("[ERROR] U(위) 또는 D(아래) 를 입력해주세요."),
    NOT_RETRY_COMMAND("[ERROR] R(재시작) 또는 Q(종료) 를 입력해주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
