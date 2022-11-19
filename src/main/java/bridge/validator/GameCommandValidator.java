package bridge.validator;

import bridge.GameRule;
import bridge.exception.ErrorMessage;

public class GameCommandValidator {

	public static String validate(String board) {
		if (!board.equals(GameRule.RETRY_COMMAND) && !board.equals(GameRule.QUIT_COMMAND)) {
			throw new IllegalArgumentException(ErrorMessage.BRIDGE_BOARD_ERROR.getMessage());
		}
		return board;
	}
}
