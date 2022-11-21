package bridge.enums;

public enum OutputMsg {
    LINE_BREAK("\n"),
    MSG_OUTPUT_START_GAME("다리 건너기 게임을 시작합니다."),
    MSG_OUTPUT_END_GAME("최종 게임 결과"),
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
