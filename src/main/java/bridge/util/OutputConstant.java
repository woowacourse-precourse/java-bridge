package bridge.util;

public enum OutputConstant {
    COMMA(", "),
    BAR("|"),
    PASS_POSSIBLE(" O "),
    PASS_IMPOSSIBLE(" X "),
    EMPTY("   ");

    private final String message;
    OutputConstant(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
