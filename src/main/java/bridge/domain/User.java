package bridge.domain;

import bridge.domain.dto.MovingResult;

public class User {
	private String moving;

	public User(String moving) {
		this.moving = moving;
	}

	public MovingResult selectMoving(int currentLocation, Bridge bridge) {
		MovingResult movingResult = bridge.judgeUserMoving(currentLocation, moving);
		return movingResult;
	}
}
