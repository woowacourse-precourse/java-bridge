package bridge.validator;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class BridgeSizeValidator {

    public static void validateBridgeSize(String input) {
        try {
            int bridgeLength = Integer.parseInt(input);
            if (bridgeLength < Constant.MIN_BRIDGE_SIZE || bridgeLength > Constant.MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_BRIDGE_SIZE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_BRIDGE_SIZE_TYPE);
        }
    }
}
