package bridge.model.constant;

import bridge.model.validate.BridgeSize;
import bridge.model.validate.ExitOption;
import bridge.model.validate.Stairs;

public enum Error {
	FORMAT("자연수만 입력해주세요."),
	RANGE(String.format("%d 에서 %d 사이의 자연수만 입력해 주세요", BridgeSize.MIN_NUMBER, BridgeSize.MAX_NUMBER)),
	STAIRS_COMMAND(String.format("%s 혹은 %s만 입력해주세요.", Stairs.UP.getCommand(), Stairs.DOWN.getCommand())),
	STAIRS_NUMBER(String.format("%d 혹은 %d만 입력해주세요.", Stairs.UP.getNumber(), Stairs.DOWN.getNumber())),
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
