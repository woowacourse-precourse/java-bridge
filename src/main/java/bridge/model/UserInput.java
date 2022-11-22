package bridge.model;

import bridge.model.constants.Command;
import bridge.model.enumeration.ExceptionMessage;

public class UserInput {

    public void validateInputMoving(String inputMoving) {
        if (!inputMoving.equals(Command.UP) && !inputMoving.equals(Command.DOWN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING_COMMAND.getExceptionMessage());
        }
    }

    public void validateRestartOrQuit(String restartOrQuit) {
        if (!restartOrQuit.equals(Command.RESTART) && !restartOrQuit.equals(Command.QUIT)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RESTARTING_COMMAND.getExceptionMessage());
        }
    }
}
