package bridge.exception;

import bridge.constant.ErrorMessage;

public class IllegalBridgeSizeException extends IllegalArgumentException {

    public IllegalBridgeSizeException() {
        super(ErrorMessage.SIZE_OF_BRIDGE.getMessage());
    }
}
