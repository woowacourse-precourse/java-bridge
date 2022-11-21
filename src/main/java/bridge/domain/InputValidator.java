package bridge.domain;

import bridge.Constants;

public class InputValidator {
    public void validateBridgeSize(String input) {
        try {
            isInRange(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_NUMBER.message());
        }
    }

    public void isInRange(int bridgeSize) {
        if (bridgeSize < Constants.BRIDGE_SIZE_MIN || bridgeSize > Constants.BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(InputErrorMessage.BRIDGE_SIZE.message());
        }
    }
}
