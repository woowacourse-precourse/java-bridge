package bridge.UI.Output;

public enum OutputString {
    START("다리 건너기 게임을 시작합니다."),
    FINAL_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: "),
    TOTAL_PLAYED_NUM("총 시도한 횟수: ");


    private final String message;

    OutputString (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
