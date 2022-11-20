package bridge.validator;

import bridge.GameRule;
import bridge.exception.ErrorMessage;

public class BridgeSizeValidator {

	public static String validate(String size) {
		isNumber(size);
		isRightRange(Integer.parseInt(size));

		return size;
	}

	private static void isNumber(String size) {
		final String REGEX = "[0-9]+";
		if (!size.matches(REGEX)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
		}
	}

	private static void isRightRange(int size) {
		if (size < GameRule.MIN_BRIDGE_LENGTH || size > GameRule.MAX_BRIDGE_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_RANGE_ERROR.getMessage());
		}
	}

}
