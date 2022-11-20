package bridge.constant;

public enum Score {
    PASS("O", "성공"),
    FAIL("X", "실패"),
    NONE(" ", "");

    private String mark;
    private String message;

    Score(String mark, String message) {
        this.mark = mark;
        this.message = message;
    }

    public String getMark() {
        return mark;
    }

    public String getMessage() {
        return message;
    }
}