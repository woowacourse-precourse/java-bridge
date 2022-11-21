package bridge.validation;

import bridge.validation.enums.ErrorMessage;
import bridge.validation.enums.RegEx;
import java.util.regex.Pattern;

public class GameCommandValidation {
    private ErrorMessage message;
    private RegEx regEx;

    public GameCommandValidation() {
    }

    public boolean isValidate(String gameCommand) {
        try {
            isNull(gameCommand);
            isBlank(gameCommand);
            isUpperCaseRQ(gameCommand);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    public void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public void isNull(String gameCommand) {
        if (gameCommand.isEmpty()) {
            message = ErrorMessage.valueOf("COMMAND_NULL_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isBlank(String gameCommand) {
        if (gameCommand.isBlank() && gameCommand.length() != 0) {
            message = ErrorMessage.valueOf("COMMAND_BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isUpperCaseRQ(String gameCommand) {
        regEx = RegEx.valueOf("COMMAND_TYPE_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), gameCommand)) {
            message = ErrorMessage.valueOf("COMMAND_TYPE_EXCEPTION");
            throwError(message.getMessage());
        }
    }
}