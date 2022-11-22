package bridge.enums;

public enum Space {
    BLANK("   "),
    SUCCESS(" O "),
    FAIL(" X ");

    private final String content;

    Space(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
