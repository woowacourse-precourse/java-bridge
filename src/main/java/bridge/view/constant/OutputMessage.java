package bridge.view.constant;

public enum OutputMessage {

    START_PHRASE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH_REQUEST_PHRASE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_DIRECTION_REQUEST_PHRASE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_QUIT_REQUEST_PHRASE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MAIN_PHRASE("최종 게임 결과"),
    GAME_RESULT_PHRASE("게임 성공 여부: %s\n"),
    TOTAL_TRY_COUNT_PHRASE("총 시도한 횟수: %d\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
