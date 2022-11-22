package bridge;

public class Valid {

	private static final int MIN_LENGTH_BRIDGE_SIZE = 1;
	private static final int MAX_LENGTH_BRIDGE_SIZE = 2;
	private static final int MIN_VALUE_BRIDGE_SIZE = 3;
	private static final int MAX_VALUE_BRIDGE_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR = "[ERROR]다리의 길이는 3부터 20이하의 숫자만 입력이 가능합니다.";

	public static int validateBridgeSizeInput(String inputSize) {
		if (inputSize.length() > MAX_LENGTH_BRIDGE_SIZE
			|| inputSize.length() < MIN_LENGTH_BRIDGE_SIZE) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
		}
		if (!isNumeric(inputSize) || !validateRangeOfBridgeSize(inputSize)) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
		}

		return Integer.parseInt(inputSize);
	}

	private static boolean validateRangeOfBridgeSize(String inputSize) {
		int bridgeSize = Integer.parseInt(inputSize);
		if (bridgeSize > MAX_VALUE_BRIDGE_SIZE
			|| bridgeSize < MIN_VALUE_BRIDGE_SIZE) {
			return false;
		}
		return true;
	}
	private static boolean isNumeric(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
