package bridge;

import bridge.io.ErrorMessage;

import java.util.Arrays;

public enum GameCommand {
	RETRY("R"),
	QUIT("Q");

	private final String gameCommandCode;

	GameCommand(String gameCommandCode) {
		this.gameCommandCode = gameCommandCode;
	}

	public static GameCommand getGameCommandByGameCommandCode(String gameCommandCode) {
		return Arrays.stream(values())
				.filter(gameCommand -> gameCommandCode.equals(gameCommand.gameCommandCode))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE));
	}
}
