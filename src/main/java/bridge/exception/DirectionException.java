package bridge.exception;

import bridge.enums.ExceptionType;

public class DirectionException extends BridgeGameRuleException {
    public DirectionException(String message, String guide) {
        super(message, ExceptionType.INPUT_IN_SERVING_SHORTCUT, guide);
    }
}
