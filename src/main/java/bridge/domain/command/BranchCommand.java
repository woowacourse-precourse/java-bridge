package bridge.domain.command;

import java.util.Arrays;

public enum BranchCommand {
	RESTART("R"),
	QUIT("Q");

	private final String value;

	BranchCommand(String value) {
		this.value = value;
	}

	public static BranchCommand findCommand(String inputCommand) {
		return Arrays.stream(BranchCommand.values()).filter(command -> command.value.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 안내문을 참고해 올바른 커맨드를 입력해주세요."));
	}

	public static boolean isRestartGame(String inputCommand) {
		return RESTART.value.equals(inputCommand);
	}

	public String getValue() {
		return value;
	}
}
