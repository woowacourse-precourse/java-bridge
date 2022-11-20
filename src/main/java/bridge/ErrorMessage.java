package bridge;

public enum ErrorMessage {

    BRIDGE_LENGTH_INPUT_ERROR_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_NOT_R_AND_NOT_Q_MESSAGE("[ERROR] R 또는 Q만 입력 가능합니다."),
    INPUT_NOT_U_AND_NOT_D_MESSAGE(String.format("[ERROR] %s 또는 %s만 입력 가능합니다.",
            StepDirectionCommand.U, StepDirectionCommand.D)),
    GAME_TRY_COUNT_OVER_MESSAGE("[ERROR] 너무 많은 게임 시도는 건강에 해롭습니다. 게임을 종료합니다."),
    NOT_MATCH_DIRECTION_MESSAGE(String.format("[ERROR] %s 또는 %s 이외의 방향이 저장되어 게임을 종료합니다.",
            StepDirectionCommand.U, StepDirectionCommand.D));

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
