package bridge.validator;

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
			throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D 만 입력 가능합니다.");
		}

	}
}
