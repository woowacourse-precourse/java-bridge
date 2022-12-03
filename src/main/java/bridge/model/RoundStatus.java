package bridge.model;

public enum RoundStatus {
    CLEAR("성공"),

    FAIL("실패"),

    PLAYING("진행 중");

    private final String text;

    RoundStatus(
            String text
    ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
