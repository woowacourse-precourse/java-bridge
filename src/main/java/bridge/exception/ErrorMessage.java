package bridge.exception;

import bridge.GameRule;

public enum ErrorMessage {

	NOT_NUMBER_ERROR("[ERROR] 숫자를 입력 해주세요"),
	BRIDGE_SIZE_RANGE_ERROR(
		"[ERROR] " + GameRule.MIN_BRIDGE_LENGTH + "에서 " + GameRule.MAX_BRIDGE_LENGTH + "사이의 숫자를 입력해 주세요"),
	BRIDGE_BOARD_ERROR("[ERROR] " + GameRule.UP_BOARD + "와 " + GameRule.DOWN_BOARD + "중에 입력해 주세요"),
	GAME_COMMAND_ERROR("[ERROR] " + GameRule.RETRY_COMMAND + "와 " + GameRule.QUIT_COMMAND + "중에 입력해 주세요");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
