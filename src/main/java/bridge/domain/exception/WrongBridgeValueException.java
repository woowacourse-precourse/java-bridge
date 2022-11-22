package bridge.domain.exception;

import bridge.utils.Constants;

public class WrongBridgeValueException extends IllegalArgumentException {

    public WrongBridgeValueException() {
        super(Constants.WRONG_BRIDGE_VALUE_MESSAGE);
    }
}
