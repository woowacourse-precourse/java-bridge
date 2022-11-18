package bridge.view;

import bridge.enums.ErrorMsg;

public class InputValidator {

	private static final int MIN_BRIDGE_LENGTH = 3;
	private static final int MAX_BRIDGE_LENGTH = 20;
	private static final String MOVE_UP = "U";
	private static final String MOVE_DOWN = "D";

	public void validateBridgeLength(String string) {
		assertStringIsPositiveNumber(string);
		assertStringIsInValidRange(string);
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

	public void validateMovement(String string) {
		if (!string.equals(MOVE_UP) && !string.equals(MOVE_DOWN)) {
			throw new IllegalArgumentException(ErrorMsg.MOVE_MSG_NOT_VALID.getMessage());
		}
	}
}
