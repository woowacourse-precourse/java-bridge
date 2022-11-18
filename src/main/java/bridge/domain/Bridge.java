package bridge.domain;

import bridge.domain.dto.MovingResult;
import java.util.List;

public class Bridge {
	private final boolean USER_GET_ANSWER_RIGHT = true;
	private final boolean USER_GET_ANSWER_WRONG = false;
	private List<String> bridge;
	private int size;

	public Bridge(List<String> bridge, int size) {
		this.bridge = bridge;
		this.size = size;
	}

	public MovingResult judgeUserMoving(int currentLocation, String userMoving) {
		String bridgeCurrentSpace = bridge.get(currentLocation);
		if (bridgeCurrentSpace.equals(userMoving)) {
			return new MovingResult(userMoving, USER_GET_ANSWER_RIGHT);
		}
		return new MovingResult(userMoving, USER_GET_ANSWER_WRONG);
	}

	public int getSize() {
		return this.size;
	}
}
