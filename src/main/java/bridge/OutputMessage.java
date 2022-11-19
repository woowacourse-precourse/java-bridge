package bridge;

public enum OutputMessage {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다." ),
    FINAL_GAME_RESULT_MESSAGE("최종 게임 결과"),
    GAME_SUCCESS_STATUS_MESSAGE("게임 성공 여부:"),
    TOTAL_TRY_COUNT_MESSAGE("총 시도한 횟수:");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
