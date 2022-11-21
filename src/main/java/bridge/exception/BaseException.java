package bridge.exception;

import static bridge.constant.ErrorMessage.ERROR_PREFIX;

public class BaseException extends IllegalArgumentException {

    public BaseException(String message) {
        super(ERROR_PREFIX + message);
    }
}
