package bridge.utils;

import bridge.utils.enums.Errors;

public class Converter {
    public int toIntFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(Errors.NOT_NUMBER.getMessage());
        }
    }

    public static String toStringFromInt(int input) {
        return Integer.toString(input);
    }
}
