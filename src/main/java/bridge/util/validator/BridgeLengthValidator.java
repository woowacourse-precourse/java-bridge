package bridge.util.validator;

import static bridge.util.constants.BridgeConstant.MAX_BRIDGE_SIZE;
import static bridge.util.constants.BridgeConstant.MIN_BRIDGE_SIZE;
import static bridge.util.constants.ErrorMessage.NUMERIC_ERROR_MESSAGE;
import static bridge.util.constants.ErrorMessage.BRIDGE_LENGTH_ERROR;

public class BridgeLengthValidator {
    private static boolean isNumeric(String input) {
        try {
            int convertedInput = Integer.parseInt(input);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private static boolean isValidLength(String input) {
        int bridgeLength = Integer.parseInt(input);
        return (MIN_BRIDGE_SIZE.getValue() <= bridgeLength && bridgeLength <= MAX_BRIDGE_SIZE.getValue());
    }

    public static void validate(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE.getMessage());
        }
        if (!isValidLength(input)) {
            String errorMessage = String.format(BRIDGE_LENGTH_ERROR.getMessage(),
                    MIN_BRIDGE_SIZE.getValue(), MAX_BRIDGE_SIZE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
