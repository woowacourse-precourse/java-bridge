package bridge.constant;

public enum ExceptionMessage {
    IS_NUMBER("[ERROR] 다리 길이는 숫자를 입력해야 합니다."),
    SCOPE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_COMMAND("[ERROR] 윗칸(U)과 아래칸(D) 중 하나를 입력해야 합니다."),
    RESTART_COMMAND("[ERROR] 재시작(R)과 종료(Q) 중 하나를 입력해야 합니다.");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
