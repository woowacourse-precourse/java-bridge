package bridge;

public class InputVerify {

	public static void verifyBridgeSize(String input) {
		verifyTrim(input);
		verifyIsNumber(input);
		verifyBridgeSizeBoundary(input);
	}

	private static void verifyTrim(String input) {
		if (input.length() != input.trim().length()) {
			BridgeGameException.illegalArgumentException("[ERROR] 입력에 공백이 들어가면 안됩니다.");
		}
	}
}
