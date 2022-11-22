package bridge.exception;

import bridge.constant.ErrorMessage;

public class IllegalMoveCommandException extends IllegalArgumentException {

    public IllegalMoveCommandException() {
        super(ErrorMessage.MOVE_COMMAND.getMessage());
    }
}
