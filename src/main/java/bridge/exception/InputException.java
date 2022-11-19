package bridge.exception;

public class InputException {
    public static int validateBridgeSize(String input) {
        return convertToNumber(input);
    }

    private static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
