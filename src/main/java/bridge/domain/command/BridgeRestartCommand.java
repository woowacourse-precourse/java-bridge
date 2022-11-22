package bridge.domain.command;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeRestartCommand {
	RETRY("R", 0),
	QUIT("Q", Integer.MAX_VALUE);
	private String command;
	private int number;

	BridgeRestartCommand(String command, int number) {
		this.command = command;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public static int getRestartCode(String input) {
		return Arrays.stream(values())
				.filter(bridgeRestartCommand -> bridgeRestartCommand.command.equals(input))
				.findAny()
				.orElseThrow(NoSuchElementException::new)
				.getNumber();
	}
}
