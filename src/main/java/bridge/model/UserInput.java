package bridge.model;

import bridge.model.enumeration.ExceptionMessage;

public class UserInput {

//    private void validateInputSize(int inputSize) {
//        if (inputSize < 3 || inputSize > 20) {
//            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getExceptionMessage());
//        }
//    }

    protected void validateInputMoving(String inputMoving) {
        if (!inputMoving.equals("U") && !inputMoving.equals("D")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING_COMMAND.getExceptionMessage());
        }
    }

    protected void validateRestartOrEnd(String restartOrEnd) {
        if (!restartOrEnd.equals("R") && !restartOrEnd.equals("Q")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RESTARTING_COMMAND.getExceptionMessage());
        }
    }
}
