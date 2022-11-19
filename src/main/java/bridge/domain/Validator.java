package bridge.domain;

import java.util.regex.Pattern;

import static bridge.constant.ConstValue.*;
import static bridge.constant.Message.*;

public class Validator {
    public void validateBridgeSize(String bridgeSize) {
        validateIsDigit(bridgeSize);
        validateRange(bridgeSize);
    }

    private void validateRange(String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);
        if (size < BRIDGE_SIZE_MINIMUM || BRIDGE_SIZE_MAXIMUM < size) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_RANGE_OUT_MESSAGE);
        }
    }

    private void validateIsDigit(String bridgeSize) {
        if (!Pattern.matches(DIGIT_REGEX, bridgeSize)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_NOT_DIGIT_MESSAGE);
        }
    }

    public void validateMoving(String moving) {
        if (!moving.equals(USER_UP_MOVING) && !moving.equals(USER_DOWN_MOVING)) {
            throw new IllegalArgumentException(INVALID_MOVE_INPUT_MESSAGE);
        }
    }
}
