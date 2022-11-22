package bridge.domain;

import bridge.utils.validator.MovingValidator;

public class User extends MovingValidator {
	private String moving;

	public User(String moving) {
		validateMoving(moving);
		this.moving = moving;
	}

	public boolean checkMoving(Bridge bridge) {
		bridge.checkUserMoving(moving);
		return bridge.getMovingResult();
	}
}
