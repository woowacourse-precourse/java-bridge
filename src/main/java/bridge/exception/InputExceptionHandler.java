package bridge.exception;

import static bridge.constant.ErrorConstant.*;

public class InputExceptionHandler {

	public static int checkBridgeSizeForm(String input) {
		int bridgeSize = isNumeric(input);
		isRange(bridgeSize);
		return bridgeSize;
	}

	private static int isNumeric(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException ErrorMessage) {
			throw new IllegalArgumentException(NOT_NUMERIC_ERROR.getMessage());
		}
	}

	private static void isRange(int bridgeSize) {
		if (bridgeSize < 3 || bridgeSize > 20) {
			throw new IllegalArgumentException(NOT_NUMBER_RANGE.getMessage());
		}
	}

	public static String checkMovingCommand(String input) {
		if (input.equals("U")) {
			return input;
		}
		if (input.equals("D")) {
			return input;
		}
		throw new IllegalArgumentException(NOT_MOVING_COMMAND.getMessage());
	}

	public static String checkRetryCommand(String input) {
		if (input.equals("R")) {
			return input;
		}
		if (input.equals("Q")) {
			return input;
		}
		throw new IllegalArgumentException(NOT_RETRY_COMMAND.getMessage());
	}
}
