package bridge.util;

import bridge.exception.InvalidNumberException;

public class IntConverter {

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }
}
