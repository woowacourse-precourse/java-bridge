package bridge.model;

public enum ContinueType {
    RETRY("R", "재시도"),
    QUIT("Q", "종료")
    ;

    private final String text;

    private final String description;

    ContinueType(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}
