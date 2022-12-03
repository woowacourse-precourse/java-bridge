package bridge.dto;

import bridge.utils.validator.MovingValidator;

public class Moving extends MovingValidator {
	private String moving;

	public Moving(String inputMoving) {
		validateMoving(inputMoving);
		this.moving = inputMoving;
	}

	public String getMoving() {
		return this.moving;
	}
}
