package bridge.view;

import static bridge.controller.Constant.*;

public class Validator {

	public static final String SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
	public static final String INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";
	private static final int MIN = 3;
	private static final int MAX = 20;

	static void isSizeValidate(int size) {
		if (size < MIN || size > MAX) {
			throw new IllegalArgumentException(SIZE_ERROR);
		}
	}

	static void isMoveValidate(String input) {
		if (!input.equals(UPSIDE) && !input.equals(DOWNSIDE)) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	static void isCommandValidate(String command) {
		if (!command.equals(RETRY_GAME) && !command.equals(QUIT_GAME)) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}
}
