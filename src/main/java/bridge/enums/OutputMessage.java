package bridge.enums;

/**
 * 결과 출력에 필요한 상수
 */
public enum OutputMessage {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    FINAL_GAME_RESULT_MESSAGE("최종 게임 결과"),
    GAME_STATUS_MESSAGE("게임 성공 여부: "),
    TOTAL_ATTEMPTS_MESSAGE("총 시도한 횟수: "),
    GAME_SUCCESS_MESSAGE("성공"),
    GAME_FAIL_MESSAGE("실패"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
