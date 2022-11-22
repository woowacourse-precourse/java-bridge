package bridge.view.constant;

public enum BridgeStyle {
    START("[" + Whitespace.SPACE.get()),
    END(Whitespace.SPACE.get() + "]"),
    DELIMITER(Whitespace.SPACE.get() + "|" + Whitespace.SPACE.get());

    private final String style;

    private BridgeStyle (String style) {
        this.style = style;
    }

    public String get() {
        return style;
    }
}
