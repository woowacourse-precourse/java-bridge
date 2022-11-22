package bridge.validation.exception;

import static bridge.constant.mark.InputMark.DOWN;
import static bridge.constant.mark.InputMark.UP;
import static bridge.validation.Message.AND;
import static bridge.validation.Message.ENTER_ONE_OF_THE_MARKS;
import static bridge.validation.Message.ERROR_MESSAGE;

public class InvalidMovingException extends IllegalArgumentException {
    public InvalidMovingException() {
        super(ERROR_MESSAGE.getMessage() + UP.getMark()
                + AND.getMessage()
                + DOWN.getMark()
                + ENTER_ONE_OF_THE_MARKS.getMessage());
    }
}
