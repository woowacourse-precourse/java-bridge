package exception;

import utils.ErrorMessage;

public class UserInputException extends IllegalArgumentException {

    public UserInputException(String message) {
        super(ErrorMessage.ERROR_HEADER.getMessage() + message);
    }
}
