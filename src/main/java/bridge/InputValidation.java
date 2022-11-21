package bridge;

import static bridge.ErrorMessage.INVALID_BRIDGE_SIZE_ERROR;

public class InputValidation {

    public static void validateReadBridgeSize(String size) {
        if (!isNumeric(size) || !isCorrectRange(size)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    private static boolean isCorrectRange(String input) {
        int numericInput = Integer.parseInt(input);
        if (numericInput >= 3 && numericInput <= 20) {
            return true;
        }
        return false;
    }

}
