package bridge;

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
		verifyIsOrder(order);
	}
}
