package bridge.view;

public enum Message {

	ERROR("[ERROR] "),
	INPUT_NOT_NUMBER("입력된 값이 숫자가 아닙니다."),
	;

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public static String getMessage(Message message) {
		return ERROR.message + message.message;
	}
}
