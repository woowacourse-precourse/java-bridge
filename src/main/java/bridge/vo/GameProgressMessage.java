package bridge.vo;

public enum GameProgressMessage {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    MOVE_MESSAGE(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            StepDirectionCommand.U, StepDirectionCommand.D)),
    GAME_RETRY_MESSAGE(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            RetryCommand.R, RetryCommand.Q)),
    FINAL_RESULT_MESSAGE("최종 게임 결과"),
    SUCCESS_OR_NOT_MESSAGE("게임 성공 여부: "),
    TOTAL_TRY_COUNT_MESSAGE("총 시도한 횟수: ");


    private String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
