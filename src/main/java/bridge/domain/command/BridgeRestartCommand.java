package bridge.domain.command;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeRestartCommand {
	RETRY("R", true),
	QUIT("Q", false);
	private String command;
	private boolean isRetry;

	BridgeRestartCommand(String command, boolean isRetry) {
		this.command = command;
		this.isRetry = isRetry;
	}


	public static boolean isRetry(String input) {
		return Arrays.stream(values())
				.filter(bridgeRestartCommand -> bridgeRestartCommand.command.equals(input))
				.findAny()
				.orElseThrow(NoSuchElementException::new)
				.isRetry();
	}

	public boolean isRetry() {
		return isRetry;
	}

	public static boolean hasGameCommand(String input) {
		return Arrays.stream(values())
				.anyMatch(bridgeGameCommand -> bridgeGameCommand.command.equals(input));
	}
}
