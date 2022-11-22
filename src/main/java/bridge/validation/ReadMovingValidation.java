package bridge.validation;

import static bridge.validation.ErrorMessage.*;

public class ReadMovingValidation {
    private static final String DOWN_MOVING_COMMAND = "D";
    private static final String UP_MOVING_COMMAND = "U";

    public void validateInputFormat(String movingCommand) {
        if ((! movingCommand.equals(DOWN_MOVING_COMMAND)) && (! movingCommand.equals(UP_MOVING_COMMAND))) {
            throw new IllegalArgumentException(INPUT_COMMAND_IN_D_OR_U.getMessage());
        }
    }
}
