package bridge;

public enum Error {
	FORMAT("자연수만 입력해주세요."),
	RANGE(String.format("%d 에서 %d 사이의 자연수만 입력해 주세요", 3, 20)),
	LOCATION(String.format("%s 혹은 %s만 입력해주세요.", Location.UP.getInputValue(), Location.DOWN.getInputValue())),
	COMMAND(String.format("%s 혹은 %s만 입력해주세요.", Command.REPLAY.getValue(), Command.QUIT.getValue())),
	;

	private static final String ERROR = "[ERROR] ";

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR + message;
	}
}
