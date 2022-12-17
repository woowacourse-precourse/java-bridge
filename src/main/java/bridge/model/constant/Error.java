package bridge.model.constant;

import bridge.model.validation.BridgeSize;
import bridge.model.validation.ExitOption;
import bridge.model.validation.Stairs;

public enum Error {
	FORMAT("자연수만 입력해주세요."),
	RANGE(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", BridgeSize.MIN.getSize(), BridgeSize.MAX.getSize())),
	STAIRS_COMMAND(String.format("%s 혹은 %s만 입력해주세요.", Stairs.UP.getCommand(), Stairs.DOWN.getCommand())),
	STAIRS_NUMBER(String.format("%d 혹은 %d만 입력해주세요.", Stairs.UP.getNumber(), Stairs.DOWN.getNumber())),
	EXIT_OPTION(String.format("%s 혹은 %s만 입력해주세요.", ExitOption.REPLAY.getCommand(), ExitOption.QUIT.getCommand())),
	EXISTENCE("이미 다리가 존재하는 경우, 다시 만들 수 없습니다."),
	ABSENCE("만들어진 다리가 없습니다. makeBridge 메서드를 사용해주세요."),
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
