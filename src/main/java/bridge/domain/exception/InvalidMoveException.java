package bridge.domain.exception;

import bridge.constant.BridgePhrase;

public class InvalidMoveException extends IllegalArgumentException {
    private static final String ERROR = BridgePhrase.ERROR_DOMAIN_MOVE.getMessage();
    public InvalidMoveException() {
        super(ERROR);
    }
}
