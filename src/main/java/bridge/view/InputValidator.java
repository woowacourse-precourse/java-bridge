package bridge.view;

import bridge.enums.ErrorMsg;
import bridge.enums.Inputs;

public class InputValidator {

	private static final int MIN_BRIDGE_LENGTH = 3;
	private static final int MAX_BRIDGE_LENGTH = 20;

	public String validateBridgeSize(String string) {
		assertStringIsPositiveNumber(string);
		assertStringIsInValidRange(string);
		return string;
	}

	private void assertStringIsPositiveNumber(String string) {
		if (!string.matches("[0-9]+")) {
			throw new IllegalArgumentException(ErrorMsg.BRIDGE_LENGTH_OUT_OF_RANGE.getMessage());
		}
	}

	private void assertStringIsInValidRange(String string) {
		int length = Integer.parseInt(string);
		if (length < MIN_BRIDGE_LENGTH || length > MAX_BRIDGE_LENGTH) {
			throw new IllegalArgumentException(ErrorMsg.BRIDGE_LENGTH_OUT_OF_RANGE.getMessage());
		}
	}

	public String validateMovement(String string) {
		if (!string.equals(Inputs.MOVE_UP.getMessage()) && !string.equals(Inputs.MOVE_DOWN.getMessage())) {
			throw new IllegalArgumentException(ErrorMsg.MOVE_MSG_NOT_VALID.getMessage());
		}
		return string;
	}

	public String validateRetry(String string) {
		if (!string.equals(Inputs.RETRY.getMessage()) && !string.equals(Inputs.QUIT.getMessage())) {
			throw new IllegalArgumentException(ErrorMsg.RETRY_MSG_NOT_VALID.getMessage());
		}
		return string;
	}
}
