package bridge.constant;

public enum ErrorConstant {
	NOT_NUMERINC_ERROR("[ERROR] 정수로 입력을 해야합니다."),
	NOT_NUMBER_RANGE("[ERROR] 다리 길이의 범위는 3 이상 20 이하입니다."),
	NOT_MOVING_COMMAND("[ERROR] 이동할 칸의 입력은 U 또는 D으로 입력을 해야합니다.");

	private final String errorMessage;

	ErrorConstant(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return errorMessage;
	}
}
