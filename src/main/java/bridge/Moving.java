package bridge;

import bridgeConstant.Constant;
import util.Validator;

public class Moving {
	private final String moving;

	public Moving(String moving) {
		Validator.validateMovingIsCellPosition(moving);
		this.moving = moving;
	}

	public boolean isUpPosition() {
		return moving.equals(Constant.UPPER_POSITION);
	}
}
