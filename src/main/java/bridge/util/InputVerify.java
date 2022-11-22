package bridge.util;

import bridge.constant.Constants;
import bridge.constant.Order;

public class InputVerify {

	public static void verifyBridgeSize(String input) {
		verifyTrim(input);
		verifyBridgeSizeBoundary(verifyIsNumber(input));
	}

	private static void verifyTrim(String input) {
		if (input.length() != input.trim().length()) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_TRIM);
		}
	}

	private static int verifyIsNumber(String input) {
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_NOT_NUMBER);
		}
		return number;
	}

	private static void verifyBridgeSizeBoundary(int bridgeSize) {
		if (bridgeSize < Constants.LOWER_SIZE || bridgeSize > Constants.UPPER_SIZE) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_SIZE_BOUNDARY);
		}
	}

	public static void verifyOrderMove(String order) {
		verifyIsMove(order);
	}

	private static void verifyIsMove(String order) {
		if (!Order.isOrderMoving(order)) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_ORDER_NOT_MOVE);
		}
	}


	public static void verifyOrderControl(String order) {
		verifyIsControl(order);
	}

	public static void verifyIsControl(String order) {
		if (!Order.isOrderControl(order)) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_ORDER_NOT_CONTROL);
		}
	}
}
