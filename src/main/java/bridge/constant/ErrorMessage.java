package bridge.constant;

public enum ErrorMessage {
	NOT_NUMERIC_ERROR("[ERROR] 정수로 입력을 해야합니다."),
	NOT_NUMBER_RANGE("[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다."),
	NOT_MOVING_COMMAND("[ERROR] 이동할 칸의 입력은 U 또는 D으로 입력을 해야합니다."),
	NOT_RETRY_COMMAND("[ERROR] 재시도할 경우 R, 종료할 경우 Q로 입력을 해야합니다."),
	NOT_MOVING_NUMBER("[ERROR] 아래칸과 위 칸에 해당하는 랜덤 숫자가 아닙니다."),
	NOT_INDEX_RANGE("[ERROR] 다리의 길이와 일치하지 않는 위치입니다.");
	private final String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return errorMessage;
	}
}
