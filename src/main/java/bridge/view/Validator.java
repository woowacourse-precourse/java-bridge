package bridge.view;

public class Validator {
	private static final String SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
	public static final String INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";

	static void isSizeValidate(int size) {
		if (size < 3 || size > 20) {
			throw new IllegalArgumentException(SIZE_ERROR);
		}
	}

	static void isMoveValidate(String input) {
		if (!input.equals("U") && !input.equals("D")) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	static void isCommandValidate(String command) {
		if (!command.equals("R") && !command.equals("Q")) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}
}
