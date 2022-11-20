package bridge;

public class InputVerify {

	public static void verifyBridgeSize(String input) {
		verifyTrim(input);
		verifyIsNumber(input);
		verifyBridgeSizeBoundary(input);
	}

	private static void verifyTrim(String input) {
		if (input.length() != input.trim().length()) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_TRIM);
		}
	}

	private static void verifyIsNumber(String input) {
		try {
			int number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			BridgeGameException.illegalArgumentException(BridgeGameException.ERROR_MESSAGE_NOT_NUMBER);
		}
	}
}
