package bridge.domain.command;

import java.util.Arrays;

public enum BranchCommand {
	RESTART("R", true),
	QUIT("Q", false);

	private final String value;
	private final boolean result;

	BranchCommand(String value, boolean result) {
		this.value = value;
		this.result = result;
	}

	public static BranchCommand findCommand(String inputCommand) {
		return Arrays.stream(BranchCommand.values()).filter(command -> command.value.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 안내문을 참고해 올바른 커맨드를 입력해주세요."));
	}

	public static boolean isContinueGame(BranchCommand branchCommand) {
		return branchCommand.result;
	}
}
