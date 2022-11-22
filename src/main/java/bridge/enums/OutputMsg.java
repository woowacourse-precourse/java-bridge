package bridge.enums;

public enum OutputMsg {
    LINE_BREAK("\n"),
    MSG_OUTPUT_START_GAME("다리 건너기 게임을 시작합니다."),
    MSG_OUTPUT_END_GAME("최종 게임 결과"),
    MSG_OUTPUT_GAME_RESULT("게임 성공 여부: "),
    MSG_OUTPUT_TRY_ATTEMPT("총 시도한 횟수: "),
    OPEN_BRACKET("[ "),
    PARTITION(" | "),
    CLOSE_BRACKET(" ]");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
