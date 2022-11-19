package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
	moveUp("U"),
	moveDown("D"),
	restartGame("R"),
	quitGame("Q");

	private final String value;

	GameCommand(String value) {
		this.value = value;
	}

	public GameCommand findCommand(String inputCommand) {
		return Arrays.stream(GameCommand.values()).filter(command -> command.value.equals(inputCommand))
			.findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 커맨드를 입력해주세요."));
	}

	public String getValue() {
		return value;
	}
}
