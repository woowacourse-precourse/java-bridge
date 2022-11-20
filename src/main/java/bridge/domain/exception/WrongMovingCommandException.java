package bridge.domain.exception;

import bridge.utils.Constants;

public class WrongMovingCommandException extends IllegalArgumentException{

    public WrongMovingCommandException() {
        super(Constants.WRONG_MOVING_COMMAND_MESSAGE);
    }
}
