package bridge;

import bridge.utils.validator.BridgeValidator;
import java.util.List;

public class Bridge extends BridgeValidator {
	private final boolean MOVING_SUCCESS = true;
	private final boolean MOVING_FAIL = false;
	private final int RESET = 0;
	private int currentLocation;
	private List<String> bridge;

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		validateBridgeSize(bridge);
		currentLocation = RESET;
		this.bridge = bridge;
	}

	public MovingResult checkUserMoving(String userMoving) {
		String currentBridgeDirection = bridge.get(currentLocation++);
		boolean isMovingSuccess = isMatch(currentBridgeDirection, userMoving);
		return new MovingResult(userMoving, isMovingSuccess);
	}

	private boolean isMatch(String currentBridgeDirection, String userMoving) {
		if (currentBridgeDirection.equals(userMoving)) {
			return MOVING_SUCCESS;
		}
		return MOVING_FAIL;
	}

	public boolean isCrossBridge() {
		if (currentLocation == bridge.size()) {
			return true;
		}
		return false;
	}

	public void resetGame() {
		this.currentLocation = RESET;
	}
}
