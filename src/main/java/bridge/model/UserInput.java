package bridge.model;

import bridge.model.constants.Command;
import bridge.model.enumeration.ExceptionMessage;

public class UserInput {

    protected void validateInputMoving(String inputMoving) {
        if (!inputMoving.equals(Command.UP) && !inputMoving.equals(Command.DOWN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING_COMMAND.getExceptionMessage());
        }
    }

    protected void validateRestartOrEnd(String restartOrEnd) {
        if (!restartOrEnd.equals(Command.RESTART) && !restartOrEnd.equals(Command.QUIT)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RESTARTING_COMMAND.getExceptionMessage());
        }
    }
}
