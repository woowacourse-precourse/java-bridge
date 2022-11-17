package bridge.validator;

public class BridgeLengthValidator {
	public static void validateNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
	}

	public static void validateRange(String input) {
		int number = Integer.parseInt(input);
		if (number < 2 || number > 20) {
			throw new IllegalArgumentException("2 이상 20 이하의 숫자를 입력해주세요.");
		}
	}
}
