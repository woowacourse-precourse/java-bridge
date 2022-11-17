package bridge;

import bridge.validator.ExitOption;
import bridge.validator.Location;

public enum Error {
	FORMAT("자연수만 입력해주세요."),
	RANGE(String.format("%d 에서 %d 사이의 자연수만 입력해 주세요", 3, 20)),
	LOCATION_COMMAND(String.format("%s 혹은 %s만 입력해주세요.", Location.UP.getCommand(), Location.DOWN.getCommand())),
	LOCATION_NUMBER(String.format("%d 혹은 %d만 입력해주세요.", Location.UP.getNumber(), Location.DOWN.getNumber())),
	EXIT_OPTION(String.format("%s 혹은 %s만 입력해주세요.", ExitOption.REPLAY.getCommand(), ExitOption.QUIT.getCommand())),
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
