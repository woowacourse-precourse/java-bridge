package bridge.validator;

import static bridge.common.exception.ErrorMessage.*;

import bridge.common.utils.StringUtils;

public class MovingValidator {
	public static void validate(final String input) {
		validateNullOrEmpty(input);
		validateRightMoving(input);
	}

	private static void validateNullOrEmpty(final String input) {
		InputValidator.validateNullOrEmpty(input);
	}

	private static void validateRightMoving(final String input) {
		if (!StringUtils.isUpOrDown(input)) {
			throw new IllegalArgumentException(NOT_UP_OR_DOWN_EXCEPTION_MESSAGE);
		}
	}
}
