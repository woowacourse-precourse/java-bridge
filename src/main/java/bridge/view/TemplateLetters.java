package bridge.view;

public enum TemplateLetters {
    START("[ "),
    MIDDLE(" | "),
    END(" ]"),
    BLANK(" ");

    private final String value;

    public String getValue() {
        return value;
    }

    TemplateLetters(String value) {
        this.value = value;
    }
}
