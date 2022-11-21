package bridge.utils.validator;

import static bridge.utils.constants.BridgeConstants.BRIDGE_SIZE_MIN_INCLUSIVE;
import static bridge.utils.constants.BridgeConstants.BRIDGE_SIZE_MAX_INCLUSIVE;
import static bridge.utils.constants.ErrorConstants.OUT_RANGE_BRIDGE_SIZE;
import static bridge.utils.constants.ErrorConstants.NOT_NUMBER_BRIDGE_SIZE;

public class BridgeValidator {

    public static int validSize(String bridgeSize) {
        int size = isNumber(bridgeSize);
        if (size < BRIDGE_SIZE_MIN_INCLUSIVE || size > BRIDGE_SIZE_MAX_INCLUSIVE) {
            throw new IllegalArgumentException(OUT_RANGE_BRIDGE_SIZE);
        }
        return size;
    }

    private static int isNumber(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_BRIDGE_SIZE);
        }
    }
}
