package bridge.common.exception;

import static bridge.common.exception.ErrorMessage.*;

public class InvalidBridgeSizeException extends BaseException {
	public InvalidBridgeSizeException() {
		super(INVALID_BRIDGE_LENGTH_EXCEPTION_MESSAGE);
	}
}
