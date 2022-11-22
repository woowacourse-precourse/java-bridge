package bridge.view;

import java.util.List;

public enum Delimiter {

    OPEN_BRACKET("[ "),
    CLOSE_BRACKET(" ]"),
    VERTICAL_LINE(" | ");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public static String joinWithVerticalLine(List<String> bridge) {
        return String.join(VERTICAL_LINE.value, bridge);
    }

    public static String openBracket(String target) {
        return OPEN_BRACKET.value + target;
    }

    public static String closeBracket(String target) {
        return CLOSE_BRACKET.value + target;
    }
}
