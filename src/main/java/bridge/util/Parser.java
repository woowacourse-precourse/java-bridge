package bridge.util;

import bridge.Lang;

public class Parser {
    public static int toIntFrom(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Lang.get(Lang.INPUT_NUMBER));
        }
    }
}
