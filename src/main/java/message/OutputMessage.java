package message;

public enum OutputMessage {
    GET_BRIDGE_SIZE_COMMENT("다리의 길이를 입력해주세요."),
    GET_MOVE_CHOICE_COMMENT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_RETRY_INTENTION_COMMENT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_INIT_COMMENT("다리 건너기 게임을 시작합니다."),
    FINAL_RESULT_COMMENT ("최종 게임 결과"),
    SUCCESS_FORMAT("게임 성공 여부: %s"),
    TOTAL_TRY_COUNT_FORMAT("총 시도한 횟수: %d"),
    ROW_MOVE_RESULT_FORMAT("[ %s ]"),
    MOVE_SUCCESS_SYMBOL("O"),
    MOVE_FAIL_SYMBOL("X"),
    GAME_SUCCESS_COMMENT("성공"),
    GAME_FAIL_COMMENT("실패"),
    BLANK_SYMBOL(" "),
    SYMBOL_PARSER(" | "),
    ERROR_FORMAT("[ERROR] %s");
    private final String message;

    public String toString(){
        return message;
    }
    OutputMessage(String message) {
        this.message = message;
    }
}
