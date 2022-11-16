package bridge.service;

import bridge.constant.ErrorMessage;

public class Validator {

    public void validateBridgeLength(String bridgeLength) {

    }

    private void validateBridgeLengthForm(String bridgeLength) {
        if (!bridgeLength.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_POSITIVE_NUMBER.message());
        }
    }

    public void validateMovement(String movement) {

    }

    public void validateRetryStatus(String retryStatus) {

    }
}
