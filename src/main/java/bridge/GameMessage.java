package bridge;

public enum GameMessage {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    REQUEST_BRIDGE_SIZE_MESSAGE("다리 길이를 입력해주세요."),
    REQUEST_MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MESSAGE("최종 게임 결과"),
    GAME_SUC_MESSAGE("게임 성공 여부: 성공"),
    GAME_FAIL_MESSAGE("게임 성공 여부: 실패"),
    GAME_TRY_CNT_MESSAGE("총 시도한 횟수: ");



    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
