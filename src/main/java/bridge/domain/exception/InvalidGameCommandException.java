package bridge.domain.exception;

import bridge.constant.BridgePhrase;

public class InvalidGameCommandException extends IllegalArgumentException {
    private static final String ERROR = BridgePhrase.ERROR_DOMAIN_GAME_COMMAND.getMessage();
    public InvalidGameCommandException() {
        super(ERROR);
    }
}
