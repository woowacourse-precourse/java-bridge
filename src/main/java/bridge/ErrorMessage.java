package bridge;

public enum ErrorMessage {
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    NOT_IN_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_SUITABLE_MOVING_COMMAND("[ERROR] U(위) 또는 R(아래) 만 입력 가능합니다."),
    NOT_SUITABLE_END_COMMAND("[ERROR] R(재시작) 또는 Q(종료) 만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
