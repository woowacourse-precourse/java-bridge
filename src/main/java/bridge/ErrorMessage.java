package bridge;

public enum ErrorMessage {
    NUMBER_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    LENGTH_ERROR("[ERROR] 한 개의 문자를 입력해야 합니다."),
    MOVING_ERROR("[ERROR] U(위 칸) 또는 D(아래 칸)를 입력해야 합니다."),
    GAME_COMMAND_ERROR("[ERROR] R(재시작) 또는 Q(종료)를 입력해야 합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
