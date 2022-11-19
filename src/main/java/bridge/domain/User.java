package bridge.domain;

import bridge.utils.validator.MovingValidator;

public class User extends MovingValidator {
	private String moving;

	public User(String moving) {
		validateMoving(moving);
		this.moving = moving;
	}

	public MovingResult selectMoving(int currentLocation, Bridge bridge) {
		MovingResult movingResult = bridge.judgeUserMoving(currentLocation, moving);
		return movingResult;
	}
}
