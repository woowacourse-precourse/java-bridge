package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class GameCommandValidation {
    private ErrorMessage message;

    public GameCommandValidation() {
    }

    public void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public void isNull(String gameCommand) {
        if (gameCommand.isEmpty()) {
            message = ErrorMessage.valueOf("COMMAND_NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String gameCommand) {
        if (gameCommand.isBlank() && gameCommand.length() != 0) {
            message = ErrorMessage.valueOf("MOVING_BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isUpperCaseRQ(String gameCommand) {
    }
}