package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class RestartOrQuitCommandException extends BaseException {
	public RestartOrQuitCommandException() {
		super(NOT_RESTART_OR_QUIT_EXCEPTION_MESSAGE);
	}
}
