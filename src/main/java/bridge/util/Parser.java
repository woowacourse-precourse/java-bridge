package bridge.util;

import bridge.type.LangType;

public class Parser {
    public static int toIntFrom(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LangType.get(LangType.INPUT_NUMBER));
        }
    }
}
