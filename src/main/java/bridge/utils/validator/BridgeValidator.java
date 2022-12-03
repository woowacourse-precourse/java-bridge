package bridge.utils.validator;

import java.util.List;

public abstract class BridgeValidator {
	private final String INVALID_BRIDGE_SIZE = "[ERROR] 다리의 길이가 3부터 20 사이가 아닙니다.\n";
	private final String INVALID_DIRECTION = "[ERROR] 다리 칸의 방향이 U나 D가 아닙니다.\n";
	private final String DIRECTION_UP = "U";
	private final String DIRECTION_DOWN = "D";
	private final int MIN_NUMBER_BOUNDARY = 3;
	private final int MAX_NUMBER_BOUNDARY = 20;

	protected void validateBridge(List<String> bridge) {
		bridge.stream()
			.forEach(direction -> validateDirection(direction));
	}

	private void validateDirection(String direction) {
		if (!direction.equals(DIRECTION_UP) && !direction.equals(DIRECTION_DOWN)) {
			throw new IllegalArgumentException(INVALID_DIRECTION);
		}
	}

	protected void validateBridgeSize(List<String> bridge) {
		if (bridge.size() < MIN_NUMBER_BOUNDARY || bridge.size() > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_BRIDGE_SIZE);
		}
	}
}
