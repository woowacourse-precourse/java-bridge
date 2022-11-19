package bridge.validator;

import static bridge.validator.ErrorConstants.ERROR_NOT_NUMBER;
import static bridge.validator.ErrorConstants.ERROR_OUT_OF_BRIDGE_RANGE;

public class BridgeValidator {
	public static void validateBridgeLength(String input) {
		validateIsNumber(input);
		validateBridgeLengthRange(Integer.parseInt(input));
	}

	private static void validateIsNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	private static void validateBridgeLengthRange(int length) {
		if (!(length >= 3 && length <= 20)) {
			throw new IllegalArgumentException(ERROR_OUT_OF_BRIDGE_RANGE);
		}
	}
}
