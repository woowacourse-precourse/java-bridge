package bridge.validator;

import static bridge.common.exception.ErrorMessage.*;

import bridge.common.utils.StringUtils;

public class InputValidator {
	public static void validateNullOrEmpty(final String input) {
		if (!StringUtils.hasText(input)) {
			throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
		}
	}

	public static void validateNumeric(final String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION_MESSAGE);
		}
	}
}
