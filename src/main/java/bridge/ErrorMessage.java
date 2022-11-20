package bridge;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 정수가 아닙니다."),
    NOT_MOVE_COMMAND("[ERROR] 알맞은 이동 명령이 아닙니다."),
    NOT_RETRY_COMMAND("[ERROR] 알맞은 재시작/종료 입력이 아닙니다."),
    NOT_VALID_RANGE("[ERROR] 유효한 범위의 숫자가 아닙니다.");

    private final String errorMessage;
    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public String toString() {
        return errorMessage;
    }
}
