package bridge;

import bridge.utils.validator.MovingValidator;

public class MovingResult extends MovingValidator {
	private final String UP_DIRECTION = "U";
	private final String DOWN_DIRECTION = "D";
	private String direction;
	private boolean result;

	public MovingResult(String direction, boolean result) {
		validateMoving(direction);
		this.direction = direction;
		this.result = result;
	}

	public boolean isMovingSuccess() {
		if (result) {
			return true;
		}
		return false;
	}

	public boolean isMovingDirectionUp() {
		if (direction.equals(UP_DIRECTION)) {
			return true;
		}
		return false;
	}

	public boolean isMovingDirectionDown() {
		if (direction.equals(DOWN_DIRECTION)) {
			return true;
		}
		return false;
	}
}
