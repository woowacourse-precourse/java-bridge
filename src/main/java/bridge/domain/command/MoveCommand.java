package bridge.domain.command;

import java.util.Arrays;

public enum MoveCommand {
	MOVE_UP(1, "U"),
	MOVE_DOWN(0, "D");

	private final int moveCode;
	private final String value;

	MoveCommand(int moveCode, String value) {
		this.moveCode = moveCode;
		this.value = value;
	}

	public static String of(int number) {
		return Arrays.stream(MoveCommand.values()).filter(command -> command.moveCode == number)
			.findFirst().orElseThrow(() -> new IllegalArgumentException("현재 커맨드에 없는 코드 값입니다.")).value;
	}

	public static MoveCommand findCommand(String inputCommand) {
		return Arrays.stream(MoveCommand.values()).filter(command -> command.value.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 안내문을 참고해 올바른 커맨드를 입력해주세요."));
	}

	public String getValue() {
		return value;
	}
}
