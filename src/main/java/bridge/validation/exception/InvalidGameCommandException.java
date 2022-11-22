package bridge.validation.exception;

import static bridge.constant.mark.InputMark.QUIT;
import static bridge.constant.mark.InputMark.RETRY;
import static bridge.validation.Message.ERROR_MESSAGE;

import bridge.validation.Message;

public class InvalidGameCommandException extends IllegalArgumentException {
    public InvalidGameCommandException() {
        super(ERROR_MESSAGE.getMessage() + RETRY.getMark()
                + Message.AND.getMessage()
                + QUIT.getMark()
                + Message.ENTER_ONE_OF_THE_MARKS.getMessage());
    }
}
