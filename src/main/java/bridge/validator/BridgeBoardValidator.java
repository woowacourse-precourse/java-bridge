package bridge.validator;

import bridge.GameRule;
import bridge.exception.ErrorMessage;

public class BridgeBoardValidator {

	public static String validate(String board) {
		if (!board.equals(GameRule.UP_BOARD) && !board.equals(GameRule.DOWN_BOARD)) {
			throw new IllegalArgumentException(ErrorMessage.BRIDGE_BOARD_ERROR.getMessage());
		}
		return board;
	}
}
