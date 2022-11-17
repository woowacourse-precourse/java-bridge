package bridge.validate;

public class Validator {
    private static final int SHORTEST_BRIDGE_LENGTH = 3;
    private static final int LONGEST_BRIDGE_LENGTH = 20;

    public static void isNum(String input) {
        input.chars().forEach(c -> {
            if (!Character.isDigit(c)) {
                String errorMessage = ErrorMessage.ERROR.toString() + ErrorMessage.INPUT_NOT_A_NUMBER;
                throw new IllegalArgumentException(errorMessage);
            }
        });
    }

    public static void isProperBridgeSize(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (!isInRange(bridgeSize, SHORTEST_BRIDGE_LENGTH, LONGEST_BRIDGE_LENGTH)) {
            String errorMessage = ErrorMessage.ERROR.toString() + ErrorMessage.NUMBER_OUT_OF_RANGE;
            throw new IllegalArgumentException(errorMessage + ErrorMessage.PROPER_BRIDGE_LENGTH);
        }
    }

    public static boolean isInRange(int num, int start, int end) {
        return start <= num && num <= end;
    }
}
