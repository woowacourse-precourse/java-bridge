package bridge.util.validator;

import bridge.util.Constants;

public class BridgeMakerValidator {

    private String bridgeLength;

    public BridgeMakerValidator(String bridgeLength) {
        this.bridgeLength = bridgeLength;
        isBridgeNull();
        isBridgeRange();
    }

    public void isBridgeNull() {
        try {
            Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_BRIDGE_NULL);
        }
    }

    public void isBridgeRange() {
        int length = Integer.parseInt(bridgeLength);

        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(Constants.ERROR_BRIDGE_RANGE);
        }
    }
}
