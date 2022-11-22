package bridge.validation;

import bridge.constant.ErrorStringConstant;
import bridge.constant.BridgeLengthConstant;
import bridge.constant.RetryExitConstant;
import bridge.constant.UpDownConstant;

public class Validation {

    public void bridgeLengthValidation(String bridgeLength) {
        try {
            int length = Integer.parseInt(bridgeLength);
            if (!(BridgeLengthConstant.BRIDGE_LENGTH.getBridgeLengthStartsFrom() <= length
                    && length <= BridgeLengthConstant.BRIDGE_LENGTH.getBridgeLengthEndsWith())) {
                throw new IllegalArgumentException(ErrorStringConstant.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.getError());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorStringConstant.BRIDGE_LENGTH_INPUT_ERROR_MESSAGE.getError());
        }
    }

    public void bridgeMovingValidation(String bridgeMoving) {
        if (!(UpDownConstant.contains(bridgeMoving))) {
            throw new IllegalArgumentException(ErrorStringConstant.UP_OR_DOWN_INPUT_ERROR_MESSAGE.getError());
        }
    }


}
