package bridge.domain.exception;

import bridge.utils.Constants;

public class NotExistCommandException extends IllegalArgumentException{

    public NotExistCommandException() {
        super(Constants.NOT_EXIST_COMMAND_MESSAGE);
    }
}
