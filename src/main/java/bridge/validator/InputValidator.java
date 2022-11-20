package bridge.validator;

import bridge.messages.ErrorMessage;

public class InputValidator {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    public static int validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_SIZE || bridgeSize > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUTBOUND_BRIDGE_SIZE_ERROR);
        }
        return bridgeSize;
    }
}
