package bridge.view.constant;

import java.util.regex.Pattern;

public enum BridgeStyle {
    START("[" + Whitespace.SPACE.get()),
    END(Whitespace.SPACE.get() + "]"),
    DELIMITER(Whitespace.SPACE.get() + "|" + Whitespace.SPACE.get()),
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
