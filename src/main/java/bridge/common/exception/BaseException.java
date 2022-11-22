package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class BaseException extends IllegalArgumentException {
	public BaseException(String message) {
		super(HEADER + message);
	}
}
