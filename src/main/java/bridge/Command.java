package bridge;

import java.util.List;

public enum Command {
	REPLAY("R"),
	QUIT("Q"),
	;

	private final String value;

	Command(String value) {
		this.value = value;
	}

	public static boolean isReplay(String inputValue) {
		String upperCase = inputValue.toUpperCase();
		validate(upperCase);
		return upperCase.equals(REPLAY.value);
	}

	public String getValue() {
		return value;
	}

	private static void validate(String inputValue) {
		List<String> commandStrings = List.of(REPLAY.value, QUIT.value);

		if (!commandStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.COMMAND.getMessage());
		}
	}
}
