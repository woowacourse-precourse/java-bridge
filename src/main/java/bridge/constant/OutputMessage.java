package bridge.constant;

public enum OutputMessage {
    GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS_OR_FAILURE("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: "),
    INDEX_START("[ "),
    INDEX_DELIMITER(" | "),
    INDEX_END(" ]");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
