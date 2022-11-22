package bridge.domain;

import java.util.Arrays;

public enum GameState {
	RETRY("R", true),
	QUIT("Q", false);

	private final String command;
	private final boolean isRetry;

	GameState(String command, boolean isRetry) {
		this.command = command;
		this.isRetry = isRetry;
	}

	public static boolean isExistedCommand(String command) {
		return Arrays.stream(GameState.values())
			.anyMatch(state -> command.equals(state.command));
	}

	public static boolean isRetryCommand(String command) {
		return Arrays.stream(GameState.values())
			.filter(state -> state.command.equals(command))
			.findFirst()
			.get()
			.isRetry;
	}
}
