package bridge.service;

import bridge.constant.ErrorMessage;

public class Validator {

    public void validateBridgeLength(String bridgeLength) {
        validateBridgeLengthForm(bridgeLength);
        validateBridgeLengthValue(Integer.parseInt(bridgeLength));
    }

    private void validateBridgeLengthForm(String bridgeLength) {
        if (!bridgeLength.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER.message());
        }
    }

    private void validateBridgeLengthValue(int bridgeLength) {
        if (bridgeLength < 3 || bridgeLength > 20) {
            throw new IllegalArgumentException(ErrorMessage.IS_OUT_OF_RANGE.message());
        }
    }

    public void validateMovement(String movement) {
        if (!movement.matches("[UD]")) {
            throw new IllegalArgumentException(ErrorMessage.IS_WRONG_MOVEMENT.message());
        }
    }

    public void validateRetryStatus(String retryStatus) {
        if (!retryStatus.matches("[RQ]")) {
            throw new IllegalArgumentException(ErrorMessage.IS_WRONG_RETRY_STATUS.message());
        }
    }
}
