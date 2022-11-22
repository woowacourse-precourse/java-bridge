package bridge;

public class Valid {

	private static final int MIN_LENGTH_BRIDGE_SIZE = 1;
	private static final int MAX_LENGTH_BRIDGE_SIZE = 2;
	private static final int MIN_VALUE_BRIDGE_SIZE = 3;
	private static final int MAX_VALUE_BRIDGE_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR = "[ERROR]다리의 길이는 3부터 20이하의 숫자만 입력이 가능합니다.";
	private static final String MOVE_ERROR = "[ERROR]이동할 칸의 입력은 U 또는 D의 입력만 가능합니다.";
	private static final String RETRY_INPUT_ERROR = "[ERROR]재시작 여부의 입력은 R 또는 Q의 입력만 가능합니다.";

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

	public static String validateMovingInput(String movingInput) {
		if (!isUorD(movingInput)
			|| !validateInputLength(movingInput)
			|| !isUpperCaseOfInput(movingInput)) {
			throw new IllegalArgumentException(MOVE_ERROR);
		}

		return movingInput;
	}

	private static boolean isUorD(String movingInput) {
		if ("U".equals(movingInput) || "D".equals(movingInput)) {
			return true;
		}
		return false;
	}

	private static boolean validateInputLength(String movingInput) {
		if (movingInput.length() == 1) {
			return true;
		}
		return false;
	}

	private static boolean isUpperCaseOfInput(String movingInput) {
		if (Character.isUpperCase(movingInput.charAt(0))) {
			return true;
		}
		return false;
	}

	public static String validateRetryInput(String retryInput) {
		if (!isRorQ(retryInput)
			|| !validateInputLength(retryInput)
			|| !isUpperCaseOfInput(retryInput)) {
			throw new IllegalArgumentException(RETRY_INPUT_ERROR);
		}

		return retryInput;
	}

	private static boolean isRorQ(String movingInput) {
		if ("R".equals(movingInput) || "Q".equals(movingInput)) {
			return true;
		}
		return false;
	}
}
