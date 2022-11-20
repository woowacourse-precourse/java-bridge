package bridge.model.validation;

import java.util.List;

import bridge.model.constant.Error;

public enum ExitOption {
	REPLAY("R"),
	QUIT("Q"),
	;

	private final String command;

	ExitOption(String command) {
		this.command = command;
	}

	public static ExitOption of(String inputValue) {
		String upperCase = inputValue.toUpperCase();
		validate(upperCase);
		if (upperCase.equals(REPLAY.command)) {
			return REPLAY;
		}
		return QUIT;
	}

	public String getCommand() {
		return command;
	}

	public boolean isReplay() {
		return this == REPLAY;
	}

	private static void validate(String inputValue) {
		List<String> commandStrings = List.of(REPLAY.command, QUIT.command);

		if (!commandStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.EXIT_OPTION.getMessage());
		}
	}
}
