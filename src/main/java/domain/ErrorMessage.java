package domain;

public enum ErrorMessage {
	WRONG_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	WRONG_MOVING("[ERROR] 위로 이동은 'U', 아래로 이동은 'D'를 입력하여야 합니다."),
	WRONG_COMMAND("[ERROR] 재시작은 'R', 종료는 'Q'를 입력하여야 합니다.");

	private final String errorMessage;

	private ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
