package bridge.validator;

import bridge.GameRule;
import bridge.exception.ErrorMessage;

public class GameCommandValidator {

	public static String validate(String command) {
		if (!command.equals(GameRule.RETRY_COMMAND) && !command.equals(GameRule.QUIT_COMMAND)) {
			throw new IllegalArgumentException(ErrorMessage.GAME_COMMAND_ERROR.getMessage());
		}
		return command;
	}
}
