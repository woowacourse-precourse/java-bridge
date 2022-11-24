package bridge.utils;

import bridge.exception.NotNumberInputException;

public class InputParser {

    public static Integer parseToInteger(String singleLine) {
        try {
            return Integer.parseInt(singleLine.trim());
        } catch (NumberFormatException err) {
            throw new NotNumberInputException();
        }
    }

    public static String parseToUpperCase(String command) {
        return command.trim().toUpperCase();
    }
}
