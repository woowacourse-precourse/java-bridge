package bridge.enums;

public enum OutputText {
    START_SYMBOL("[ "),
    END_SYMBOL (" ]"),
    SUCCESS("성공"),
    FAIL("실패"),
    FINAL_RESULT("최종 게임 결과"),
    SUCCESS_TEXT("게임 성공 여부: "),
    TRY_COUNT_TEXT("총 시도한 횟수: ");

    private String text;

    OutputText(String text) {
        this.text = text;
    }

    public String getValue() {
        return text;
    }
}
