package bridge.util.validator;

import static bridge.util.constants.BridgeConstant.LOWER_BRIDGE_NUMBER;
import static bridge.util.constants.BridgeConstant.UPPER_BRIDGE_NUMBER;
import static bridge.util.constants.ErrorMessage.BRIDGE_NUMBER_ERROR;

public class BridgeNumberValidator {
    public static void validate(int number) {
        if (number != LOWER_BRIDGE_NUMBER.getValue() && number != UPPER_BRIDGE_NUMBER.getValue()) {
            throw new IllegalStateException(BRIDGE_NUMBER_ERROR.getMessage());
        }
    }
}
