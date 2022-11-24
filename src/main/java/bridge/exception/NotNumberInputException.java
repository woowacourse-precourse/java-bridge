package bridge.exception;

import bridge.constant.ErrorMessage;

public class NotNumberInputException extends IllegalArgumentException {

    public NotNumberInputException() {
        super(ErrorMessage.NOT_NUMBER.getMessage());
    }
}
