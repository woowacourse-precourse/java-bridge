package bridge.constant;

public enum OutputViewMessage {

    BAR(" | "),
    LEFT_BOARDER("[ "),
    RIGHT_BOARDER(" ]"),
    FINAL_GAME_RESULT_MESSAGE("최종 게임 결과"),
    RETRY_SUM_MESSAGE("총 시도한 횟수: "),
    SUCCESS_MESSAGE("게임 성공 여부: 성공"),
    FAIL_MESSAGE("게임 성공 여부: 실패"),
    START_MESSAGE("다리 건너기 게임을 시작합니다.");

    private String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
