package bridge.utils.validator;

public abstract class MovingValidator {
	private final String INVALID_INPUT_MOVING = "[ERROR] U와 D 중에서만 입력할 수 있습니다.\n";
	private final String LOWER_INCLUSIVE = "D";
	private final String UPPER_INCLUSIVE = "U";

	protected void validateMoving(String Moving) {
		if (!Moving.equals(LOWER_INCLUSIVE) && !Moving.equals(UPPER_INCLUSIVE)) {
			throw new IllegalArgumentException(INVALID_INPUT_MOVING);
		}
	}
}
