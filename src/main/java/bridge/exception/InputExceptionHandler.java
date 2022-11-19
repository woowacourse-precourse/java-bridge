package bridge.exception;

import static bridge.constant.Constant.*;
import static bridge.constant.ErrorMessage.*;
import static bridge.constant.NumericConstant.*;

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
		if (bridgeSize < MIN_BRIDGE_SIZE.getConstValue() || bridgeSize > MAX_BRIDGE_SIZE.getConstValue()) {
			throw new IllegalArgumentException(NOT_NUMBER_RANGE.getMessage());
		}
	}

	public static String checkMovingCommand(String input) {
		if (input.equals(UP_BRIDGE_COMMAND.getConstant())) {
			return input;
		}
		if (input.equals(DOWN_BRIDGE_COMMAND.getConstant())) {
			return input;
		}
		throw new IllegalArgumentException(NOT_MOVING_COMMAND.getMessage());
	}

	public static String checkRetryCommand(String input) {
		if (input.equals(RETRY_COMMAND.getConstant())) {
			return input;
		}
		if (input.equals(QUIT_COMMAND.getConstant())) {
			return input;
		}
		throw new IllegalArgumentException(NOT_RETRY_COMMAND.getMessage());
	}
}
