package bridge.validator;

import static bridge.messages.ErrorMessage.NON_NUMERIC_BRIDGE_SIZE_ERROR;
import static bridge.messages.ErrorMessage.OUTBOUND_BRIDGE_SIZE_ERROR;

public class InputValidator {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    public static int validateBridgeSize(String inputBridgeSize) {
        int bridgeSize = getAnInt(inputBridgeSize);
        if (bridgeSize < MINIMUM_SIZE || bridgeSize > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OUTBOUND_BRIDGE_SIZE_ERROR);
        }
        return bridgeSize;
    }

    private static int getAnInt(final String inputBridgeSize) {
        try {
            return Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMERIC_BRIDGE_SIZE_ERROR);
        }
    }
}
