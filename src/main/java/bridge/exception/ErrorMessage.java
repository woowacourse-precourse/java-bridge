package bridge.exception;

import bridge.GameRule;

public enum ErrorMessage {

	NOT_NUMBER_ERROR("[ERROR] 숫자를 입력 해주세요"),
	BRIDGE_SIZE_RANGE_ERROR(
		"[ERROR] " + GameRule.MIN_BRIDGE_LENGTH + "에서 " + GameRule.MAX_BRIDGE_LENGTH + "사이의 숫자를 입력해 주세요");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
