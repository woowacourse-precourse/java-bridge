package bridge.domain;

import bridge.utils.validator.BridgeValidator;
import java.util.List;

public class Bridge extends BridgeValidator {
	private final boolean MOVING_SUCCESS = true;
	private final boolean MOVING_FAIL = false;
	private int currentLocation = 0;
	private List<String> bridge;
	private BridgeMap bridgeMap = new BridgeMap();

	public Bridge(List<String> bridge) {
		validateBridge(bridge);
		validateBridgeSize(bridge);
		this.bridge = bridge;
	}

	public void checkUserMoving(String userMoving) {
		String currentBridgeDirection = bridge.get(currentLocation++);
		boolean isMovingSuccess = MOVING_FAIL;
		if (currentBridgeDirection.equals(userMoving)) {
			isMovingSuccess = MOVING_SUCCESS;
		}
		MovingResult movingResult = new MovingResult(userMoving, isMovingSuccess);
		bridgeMap.addMovingResult(movingResult);
	}

	public BridgeMap getBridgeMap() {
		return bridgeMap;
	}

	public boolean getMovingResult() {
		return bridgeMap.getMovingResult();
	}

	public boolean isCrossBridge() {
		if (currentLocation == bridge.size()) {
			return true;
		}
		return false;
	}

	public void resetGame() {
		this.currentLocation = 0;
		bridgeMap.resetMap();
	}
}
