package bridge.validator;

import bridge.common.exception.RestartOrQuitCommandException;

public class GameCommandValidator {
	private static final String RESTART_COMMAND = "R";
	private static final String QUIT_COMMAND = "Q";

	public static void validate(final String input) {
		validateNullOrEmpty(input);
		validateRightGameCommand(input);
	}

	private static void validateNullOrEmpty(final String input) {
		InputValidator.validateNullOrEmpty(input);
	}

	private static void validateRightGameCommand(final String input) {
		if (!isRightCommand(input)) {
			throw new RestartOrQuitCommandException();
		}
	}

	private static boolean isRightCommand(final String input) {
		return input.equals(RESTART_COMMAND) || input.equals(QUIT_COMMAND);
	}
}
