package bridge.view;

public enum OutputMessage {
    START_LINE("["),
    END_LINE("]"),
    SUCCESS(" O "),
    FAIL(" X "),
    EMPTY("   "),
    SPLIT("|");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }


}
