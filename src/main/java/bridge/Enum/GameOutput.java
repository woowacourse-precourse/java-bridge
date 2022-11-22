package bridge.Enum;

public enum GameOutput {
    COMMA(", "),
    BAR("|"),
    PASS_POSSIBLE(" O "),
    PASS_IMPOSSIBLE(" X "),
    EMPTY("   "),
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    ;

    private final String message;

    GameOutput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
