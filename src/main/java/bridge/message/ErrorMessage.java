package bridge.message;

public enum ErrorMessage {
    BRIDGE_LENGTH_IS_NOT_DIGIT("[ERROR] 다리 길이는 숫자여야 합니다."),
    BRIDGE_LENGTH_OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_IS_NOT_U_D("[ERROR] 이동할 칸에 대한 입력은 'U' 또는 'D'여야 합니다."),
    GAME_COMMAND_IS_NOT_Q_R("[ERROR] 게임 재시작/종료 여부에 대한 입력은 'R' 또는 'Q'여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
