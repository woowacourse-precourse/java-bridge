package bridge.exception;

import bridge.constant.ErrorMessage;

public class IllegalPositionInFormOfNumberException extends IllegalArgumentException {

    public IllegalPositionInFormOfNumberException() {
        super(ErrorMessage.POSITION_IN_FORM_OF_NUMBER.getMessage());
    }
}
