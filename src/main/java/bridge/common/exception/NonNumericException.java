package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class NonNumericException extends BaseException {
	public NonNumericException() {
		super(NON_NUMERIC_EXCEPTION_MESSAGE);
	}
}
