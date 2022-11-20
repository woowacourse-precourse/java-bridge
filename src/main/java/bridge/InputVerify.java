package bridge;

public class InputVerify {

	public static void verifyBridgeSize(String input) {
		verifyTrim(input);
		verifyIsNumber(input);
		verifyBridgeSizeBoundary(input);
	}
}
