package bridge.exception;

public class InputException {
    public static int validateBridgeSize(String input) {
        int size = convertToNumber(input);
        accurateRange(size);
        return size;
    }

    private static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeNumber.getPhrase());
        }
    }

    private static void accurateRange(int size) {
        if(!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeRange.getPhrase());
        }
    }
}
