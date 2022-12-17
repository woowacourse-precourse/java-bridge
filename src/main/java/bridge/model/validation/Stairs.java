package bridge.model.validation;

import java.util.List;

import bridge.model.constant.Error;

public enum Stairs {
	UP("U", 1),
	DOWN("D", 0),
	;

	private final String command;
	private final int number;

	Stairs(String command, int number) {
		this.command = command;
		this.number = number;
	}

	public String getCommand() {
		return command;
	}

	public int getNumber() {
		return number;
	}

	public boolean isEquals(String square) {
		return command.equals(square.toUpperCase());
	}

	public static Stairs of(int inputValue) {
		validate(inputValue);
		if (inputValue == UP.number) {
			return UP;
		}
		return DOWN;
	}

	public static Stairs of(String inputValue) {
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
			throw new IllegalArgumentException(Error.STAIRS_COMMAND.getMessage());
		}
	}

	private static void validate(int inputValue) {
		List<Integer> locationStrings = List.of(UP.number, DOWN.number);

		if (!locationStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.STAIRS_NUMBER.getMessage());
		}
	}

}
