package bridge.validation.exception;

import static bridge.validation.Message.ENTER_ONE_CHARACTER;
import static bridge.validation.Message.ERROR_MESSAGE;

public class NotOneCharacterException extends IllegalArgumentException {
    public NotOneCharacterException() {
        super(ERROR_MESSAGE.getMessage() + ENTER_ONE_CHARACTER.getMessage());
    }
}
