package bridge.validator;

import static bridge.validator.ErrorConstants.ERROR_NOT_U_OR_D;

public class MoveValidator {
	public static void validateMovingPath(String input) {
		if (!(input.equals("U") || input.equals("D"))) {
			throw new IllegalArgumentException(ERROR_NOT_U_OR_D);
		}
	}
}
