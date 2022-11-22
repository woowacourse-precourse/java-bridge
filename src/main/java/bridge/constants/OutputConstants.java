package bridge.constants;

public enum OutputConstants {
    START_BRACKET("[ "),
    APPEND_DIVISION(" | "),
    END_BRACKET(" ]"),
    GAME_RESULT("최종 게임 결과"),
    IS_SUCCESS_GAME("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: "),
    SUCCESS_GAME("성공"),
    FAIL_GAME("실패");

    private String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
