package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class NotUpOrDownCommandException extends BaseException {
	public NotUpOrDownCommandException() {
		super(NOT_UP_OR_DOWN_EXCEPTION_MESSAGE);
	}
}
