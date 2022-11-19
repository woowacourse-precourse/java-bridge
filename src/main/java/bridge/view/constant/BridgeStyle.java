package bridge.view.constant;

public enum BridgeStyle {
    START("["),
    END("]"),
    DELIMITER("|"),
    CORRECT_PANEL("O"),
    WRONG_PANEL("X"),
    EMPTY_PANEL(" ");

    private final String style;

    private BridgeStyle (String style) {
        this.style = style;
    }

    public String get() {
        return style;
    }
}
