package bridge.domain.exception;

import bridge.utils.Constants;

public class WrongNumberInputException extends IllegalArgumentException {

    public WrongNumberInputException() {
        super(Constants.WRONG_INPUT_SIZE_MESSAGE);
    }
}
