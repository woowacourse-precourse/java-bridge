package validator;

public class BridgeValidator {
	public void validateBridgeLength(String input) {
		validateIsNumber(input);
		validateBridgeLengthRange(Integer.parseInt(input));
	}

	private void validateIsNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
		}
	}

	private void validateBridgeLengthRange(int length) {
		if (!(length >= 3 && length <= 20)) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}
}
