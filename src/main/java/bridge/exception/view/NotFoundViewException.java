package bridge.exception.view;

import bridge.utils.message.ExceptionMessageUtils;

public class NotFoundViewException extends RuntimeException {

    public NotFoundViewException() {
        super(ExceptionMessageUtils.NOT_FOUND_VIEW.getMessage());
    }
}
