package bridge.commom.validation;

import static bridge.commom.constant.BridgeLimit.*;
import static bridge.commom.constant.GameMessage.Exception;

public class BridgeValidator {

    public static void isProperlyBridgeSize(int size) {
        if (size < MINIMUM_LIMIT || MAXIMUM_LIMIT < size) {
            throw new IllegalArgumentException(Exception.BRIDGE_SIZE);
        }
    }
}
