package bridge.model;

import java.util.Optional;

public class UserInputExceptions {
	public static boolean isNotValidLength(String length) {
		if (isNotNumber(length) || isNotInRangeNumber(length)) {
			throw new IllegalArgumentException(Messages.wrongLengthErrorMessage);
		}
		return false;
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
