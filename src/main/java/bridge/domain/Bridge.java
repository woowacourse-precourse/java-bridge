package bridge.domain;

import bridge.utils.validator.BridgeValidator;
import java.util.List;

public class Bridge extends BridgeValidator {
	private final boolean MOVING_SUCCESS = true;
	private final boolean MOVING_FAIL = false;
	private List<String> bridge;
	private int currentLocation = 0;

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		validateBridgeSize(bridge);
		this.bridge = bridge;
	}

	public MovingResult checkUserMoving(String userMoving) {
		String currentBridgeDirection = bridge.get(currentLocation++);
		if (currentBridgeDirection.equals(userMoving)) {
			return new MovingResult(userMoving, MOVING_SUCCESS);
		}
		return new MovingResult(userMoving, MOVING_FAIL);
	}

	public boolean isCrossBridge() {
		if (currentLocation == bridge.size()) {
			return true;
		}
		return false;
	}

	public void resetCurrentLocation() {
		this.currentLocation = 0;
	}
}
