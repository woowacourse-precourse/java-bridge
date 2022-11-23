package bridge.validator;

import static bridge.common.exception.ErrorMessage.*;

public class BridgeSizeValidator {
	public static void validate(final String input) {
		validateNullOrEmpty(input);
		validateNumeric(input);
		validateRange(Integer.parseInt(input));
	}

	private static void validateNullOrEmpty(final String input) {
		InputValidator.validateNullOrEmpty(input);
	}

	private static void validateNumeric(final String input) {
		InputValidator.validateNumeric(input);
	}

	private static void validateRange(final int bridgeSize) {
		if (bridgeSize < 3 || bridgeSize > 20) {
			throw new IllegalArgumentException(INVALID_BRIDGE_LENGTH_EXCEPTION_MESSAGE);
		}
	}
}
