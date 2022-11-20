package bridge.exception;

import bridge.constant.GameConstant;
import bridge.domain.Move;

public class InputExceptionHandler {

	private static final String NOT_NUMERIC_ERROR = "[ERROR] 정수로 입력을 해야합니다.";
	private static final String NOT_NUMBER_RANGE = "[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다.";
	private static final String NOT_RETRY_COMMAND = "[ERROR] 재시도할 경우 R, 종료할 경우 Q로 입력을 해야합니다.";

	public static int checkBridgeSizeForm(String input) {
		int bridgeSize = isNumeric(input);
		isRange(bridgeSize);
		return bridgeSize;
	}

	private static int isNumeric(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException ErrorMessage) {
			throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
		}
	}

	private static void isRange(int bridgeSize) {
		if (bridgeSize < GameConstant.MIN_BRIDGE_SIZE || bridgeSize > GameConstant.MAX_BRIDGE_SIZE) {
			throw new IllegalArgumentException(NOT_NUMBER_RANGE);
		}
	}

	public static Move checkMovingCommand(String input) {
		return Move.find(input);
	}

	public static String checkRetryCommand(String input) {
		if (input.equals(GameConstant.RETRY_COMMAND)) {
			return input;
		}
		if (input.equals(GameConstant.QUIT_COMMAND)) {
			return input;
		}
		throw new IllegalArgumentException(NOT_RETRY_COMMAND);
	}
}
