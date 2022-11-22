package bridge.exception;

import static bridge.constant.ErrorMessage.WRONG_MOVING;

public class WrongMovingException extends BaseException {

    public WrongMovingException() {
        super(WRONG_MOVING);
    }
}
