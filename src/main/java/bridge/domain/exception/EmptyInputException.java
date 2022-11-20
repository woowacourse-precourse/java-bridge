package bridge.domain.exception;

import bridge.utils.Constants;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super(Constants.EMPTY_INPUT_MESSAGE);
    }
}
