package bridge.validator;

import static bridge.Constants.*;
import static bridge.Message.*;

public class BridgeLengthValidate {
	public static void validateNumber(String input) {
		if (!input.matches(NUMBERS_ONLY)) {
			throw new IllegalArgumentException(ERROR_NUMBERS_ONLY);
		}
	}

	public static void validateRange(String input) {
		int number = Integer.parseInt(input);
		if (number < 2 || number > 20) {
			throw new IllegalArgumentException(ERROR_RANGE);
		}
	}
}
