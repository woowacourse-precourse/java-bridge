package bridge.utils;

public class InputValidator {

    public static int isBridgeSizeNumeric(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
