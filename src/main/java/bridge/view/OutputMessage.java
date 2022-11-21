package bridge.view;

public enum OutputMessage {
    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: %s\n"),
    ATTEMPT("총 시도한 횟수: %d\n"),
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
