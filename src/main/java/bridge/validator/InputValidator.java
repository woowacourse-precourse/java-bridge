package bridge.validator;

import bridge.common.exception.NonNumericException;
import bridge.common.exception.NullOrEmptyException;
import bridge.common.utils.StringUtils;

public class InputValidator {
	public static void validateNullOrEmpty(final String input) {
		if (!StringUtils.hasText(input)) {
			throw new NullOrEmptyException();
		}
	}

	public static void validateNumeric(final String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new NonNumericException();
		}
	}
}
