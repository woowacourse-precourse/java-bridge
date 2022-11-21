package bridge.validate;

import bridge.message.Error;

public class InputValidate {
    public void validateBridgeSize(String length) {
        try {
            int bridgeSize = Integer.parseInt(length);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
        }
    }

    public void validateMoving(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException(Error.WRONG_INPUT);
        }
    }

    public void validateRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(Error.WRONG_INPUT);
        }
    }
}
