package bridge.model;

public class UserInputExceptions {
	public static boolean isNotValidLength(String length) {
		return isNotNumber(length) || isNotInRangeNumber(length);
	}

	private static boolean isNotNumber(String length) {
		try {
			Integer.parseInt(length);
		} catch (IllegalArgumentException exception) {
			return true;
		}
		return false;
	}

	private static boolean isNotInRangeNumber(String length) {
		int number = Integer.parseInt(length);
		return number < 3 || number > 20;
	}
}
