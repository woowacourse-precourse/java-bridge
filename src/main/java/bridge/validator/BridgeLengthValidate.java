package bridge.validator;

import static bridge.util.Constants.*;
import static bridge.util.Message.*;

public class BridgeLengthValidate {
	public static void validateNumber(String input) {
		if (!input.matches(NUMBERS_ONLY)) {
			throw new IllegalArgumentException(ERROR_NUMBERS_ONLY);
		}
	}

	public static void validateRange(String input) {
		int number = getNumber(input);
		if (isOutOfRange(number)) {
			throw new IllegalArgumentException(ERROR_RANGE);
		}
	}

	private static int getNumber(String input) {
		return Integer.parseInt(input);
	}

	private static boolean isOutOfRange(int number) {
		return number < 2 || number > 20;
	}
}
