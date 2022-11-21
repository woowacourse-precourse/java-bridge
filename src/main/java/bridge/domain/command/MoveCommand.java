package bridge.domain.command;

import java.util.Arrays;
import java.util.List;

public enum MoveCommand {
	MOVE_UP("U"),
	MOVE_DOWN("D");


	private final String value;

	MoveCommand(String value) {
		this.value = value;
	}

	public static MoveCommand findCommand(String inputCommand) {
		return Arrays.stream(MoveCommand.values()).filter(command -> command.value.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 안내문을 참고해 올바른 커맨드를 입력해주세요."));
	}

	public String getValue() {
		return value;
	}
}
