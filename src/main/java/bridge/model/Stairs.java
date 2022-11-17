package bridge.model;

import java.util.List;

import bridge.Error;

public enum Location {
	UP("U", 1),
	DOWN("D", 0),
	;

	private final String command;
	private final int number;

	Location(String command, int number) {
		this.command = command;
		this.number = number;
	}

	public String getCommand() {
		return command;
	}

	public int getNumber() {
		return number;
	}

	public int getAnotherNumber() {
		if (number == 1) {
			return 0;
		}
		return 1;
	}

	public static Location of(int inputValue) {
		validate(inputValue);
		if (inputValue == UP.number) {
			return UP;
		}
		return DOWN;
	}

	public static Location of(String inputValue) {
		String upperCase = inputValue.toUpperCase();
		validate(upperCase);
		if (upperCase.equals(UP.command)) {
			return UP;
		}
		return DOWN;
	}

	private static void validate(String inputValue) {
		List<String> locationStrings = List.of(UP.command, DOWN.command);

		if (!locationStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.LOCATION_COMMAND.getMessage());
		}
	}

	private static void validate(int inputValue) {
		List<Integer> locationStrings = List.of(UP.number, DOWN.number);

		if (!locationStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.LOCATION_NUMBER.getMessage());
		}
	}

}
