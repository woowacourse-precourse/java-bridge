package bridge.utils.validator;

import static bridge.utils.constants.ErrorConstants.OUT_RANGE_BRIDGE_SIZE;
import static bridge.utils.constants.ErrorConstants.NOT_NUMBER_BRIDGE_SIZE;

public class BridgeValidator {

    public static void validSize(String bridgeSize) {
        int size = isNumber(bridgeSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(OUT_RANGE_BRIDGE_SIZE);
        }
    }

    private static int isNumber(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_BRIDGE_SIZE);
        }
    }
}
