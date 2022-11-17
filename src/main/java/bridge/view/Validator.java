package bridge.view;

import static bridge.controller.Constant.*;

public class Validator {

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
