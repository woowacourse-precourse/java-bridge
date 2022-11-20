package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class GameCommandValidation {
    private ErrorMessage message;

    public GameCommandValidation() {
    }

    public void isNull(String gameCommand) {
        if (gameCommand.isEmpty()) {
            message = ErrorMessage.valueOf("COMMAND_NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String gameCommand) {
    }

    public void isUpperCaseRQ(String gameCommand) {
    }
}