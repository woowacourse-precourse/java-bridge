package bridge.domain;

import java.util.List;

public class Bridge {
	private final String INVALID_BRIDGE_SIZE = "[ERROR] 다리의 길이가 3~20사이가 아닙니다.";
	private final String INVALID_DIRECTION = "[ERROR] 다리 칸의 방향이 U나 D가 아닙니다.";
	private final String DIRECTION_UP = "U";
	private final String DIRECTION_DOWN = "D";
	private final boolean USER_GET_ANSWER_RIGHT = true;
	private final boolean USER_GET_ANSWER_WRONG = false;
	private final int MIN_NUMBER_BOUNDARY = 3;
	private final int MAX_NUMBER_BOUNDARY = 20;
	private List<String> bridge;
	private int currentLocation = 0;

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		validateBridgeSize(bridge);
		this.bridge = bridge;
	}

	private void validateBridge(List<String> bridge) {
		bridge.stream()
			.forEach(direction -> validateDirection(direction));
	}

	private void validateDirection(String direction) {
		if (!direction.equals(DIRECTION_UP) && !direction.equals(DIRECTION_DOWN)) {
			throw new IllegalArgumentException(INVALID_DIRECTION);
		}
	}

	private void validateBridgeSize(List<String> bridge) {
		if (bridge.size() < MIN_NUMBER_BOUNDARY || bridge.size() > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
		}
	}

	public MovingResult checkUserMoving(String userMoving) {
		String currentBridgeDirection = bridge.get(currentLocation++);
		if (currentBridgeDirection.equals(userMoving)) {
			return new MovingResult(userMoving, USER_GET_ANSWER_RIGHT);
		}
		return new MovingResult(userMoving, USER_GET_ANSWER_WRONG);
	}

	public boolean isMovingEnd() {
		if (currentLocation == bridge.size()) {
			return true;
		}
		return false;
	}

	public void resetCurrentLocation() {
		this.currentLocation = 0;
	}
}
