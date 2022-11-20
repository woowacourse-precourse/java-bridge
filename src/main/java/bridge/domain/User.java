package bridge.domain;

import bridge.utils.MovingValidator;

public class User extends MovingValidator {
	private String moving;

	public User(String moving) {
		validateMoving(moving);
		this.moving = moving;
	}

	public MovingResult selectMoving(Bridge bridge) {
		MovingResult movingResult = bridge.checkUserMoving(moving);
		return movingResult;
	}
}
