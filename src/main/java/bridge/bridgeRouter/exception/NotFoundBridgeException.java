package bridge.bridgeRouter.exception;

import bridge.common.ErrorMessage;

public class NotFoundBridgeException extends IllegalStateException {
    private static final String MESSAGE = ErrorMessage.NOT_FOUND_BRIDGE.getTagMessage();

    public NotFoundBridgeException() {
        super(MESSAGE);
    }
}
