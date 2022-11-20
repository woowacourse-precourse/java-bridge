package bridge.view;

public enum OutputMessage {
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: %s"),
    ATTEMPT("총 시도한 횟수: %d"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
