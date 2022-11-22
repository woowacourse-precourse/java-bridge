package console;

public enum OutputMessage {
    UP("U"),
    DOWN("D"),
    FIRST("F"),
    SECOND("S"),
    FINAL_RESULT("최종 게임 결과"),
    SUCCEEDED("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    ATTEMPT("\n총 시도한 횟수: ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
