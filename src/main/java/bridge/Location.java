package bridge;

import java.util.List;

public enum Location {
	UP("U", 1),
	DOWN("D", 0),
	;

	private final String inputValue;
	private final int convertValue;

	Location(String inputValue, int convertValue) {
		this.inputValue = inputValue;
		this.convertValue = convertValue;
	}

	public static int convertToInt(String inputValue) {
		String upperCase = inputValue.toUpperCase();
		validate(upperCase);
		if (upperCase.equals(UP.inputValue)) {
			return UP.convertValue;
		}
		return DOWN.convertValue;
	}

	private static void validate(String inputValue) {
		List<String> locationStrings = List.of(UP.inputValue, DOWN.inputValue);

		if (!locationStrings.contains(inputValue)) {
			throw new IllegalArgumentException(Error.LOCATION.getMessage());
		}
	}

}
