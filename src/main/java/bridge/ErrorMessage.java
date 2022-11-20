package bridge;

public enum ErrorMessage {

	ERROR_WRONG_SIZE("[ERROR] 3이상 20이하의 정수를 입력하시오.");
	private final String error_message;

	ErrorMessage(String error_message) {
		this.error_message = error_message;
	}

	public String getErrorMessage() {
		return error_message;
	}

}
