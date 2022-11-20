package bridge.util.validator;

import bridge.util.Constants;

public class BridgeMoveValidator {

    private String bridgeLocation;

    public BridgeMoveValidator(String bridgeLocation) {
        this.bridgeLocation = bridgeLocation;
        isEmpty();
        isRightLength();
        isRightForm();
    }

    public void isEmpty() {
        if (bridgeLocation.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_LOCATION_EMPTY);
        }
    }

    public void isRightLength() {
        if (bridgeLocation.length() != 1) {
            throw new IllegalArgumentException(Constants.ERROR_LOCATION_RIGHT_LENGTH);
        }
    }

    public void isRightForm() {
        if ((bridgeLocation != "U") && (bridgeLocation != "D")) {
            throw new IllegalArgumentException(Constants.ERROR_LOCATION_RIGHT_FORM);
        }
    }
}