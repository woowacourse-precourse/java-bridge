package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class NullOrEmptyException extends BaseException {
	public NullOrEmptyException() {
		super(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
	}
}
