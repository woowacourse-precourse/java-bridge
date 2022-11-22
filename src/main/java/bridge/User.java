package bridge;

import bridge.dto.Moving;

public class User {
	private Bridge bridge;
	private BridgeMap bridgeMap = new BridgeMap();

	public User(Bridge bridge) {
		this.bridge = bridge;
	}

	public boolean checkMoving(Moving moving) {
		MovingResult movingResult = bridge.checkUserMoving(moving.getMoving());
		bridgeMap.addMovingResult(movingResult);
		return movingResult.isMovingSuccess();
	}

	public boolean isKeepMove() {
		return bridge.isCrossBridge();
	}

	public BridgeMap getBridgeMap() {
		return bridgeMap;
	}

	public void resetGame() {
		bridge.resetGame();
		bridgeMap.resetMap();
	}
}
