package bridge.domain.exception;

import bridge.constant.BridgePhrase;

public class OutOfBridgeSizeBoundaryException extends IllegalArgumentException {
    private static final String ERROR = BridgePhrase.ERROR_DOMAIN_BRIDE_SIZE.getMessage();
    public OutOfBridgeSizeBoundaryException() {
        super(ERROR);
    }
}
