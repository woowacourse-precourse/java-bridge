package bridge.validator;

import java.util.List;

import bridge.Error;

public enum Option {
	REPLAY("R"),
	QUIT("Q"),
	;

	private final String command;

	Option(String command) {
		this.command = command;
	}

	public static boolean isReplay(String inputValue) {
		String upperCase = inputValue.toUpperCase();
		validate(upperCase);
		return upperCase.equals(REPLAY.command);
	}

	public String getCommand() {
		return command;
	}

	private static void validate(String inputValue) {
		List<String> commandStrings = List.of(REPLAY.command, QUIT.command);

		if (!commandStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.COMMAND.getMessage());
		}
	}
}
