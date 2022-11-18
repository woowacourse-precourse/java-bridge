package bridge.enums;

public enum ErrorMsg {
	BRIDGE_LENGTH_OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	MOVE_MSG_NOT_VALID("[ERROR] 이동할 칸의 입력은 U또는 D여야 합니다."),
	RETRY_MSG_NOT_VALID("[ERROR] 재시도 여부의 입력은 R또는 Q여야 합니다.");

	private String message;

	ErrorMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
