package bridge.domain;

public class BridgeGame {
	private final Bridge bridge;
	private int repeatCount;

	public BridgeGame(Bridge bridge) {
		this.bridge = bridge;
		this.repeatCount = 1;
	}

	public void move(String input, ProgressMap gameProgress) {
		int moveCount = gameProgress.getMapSize();
		gameProgress.updateProgressMap(input, bridge.isCorrectMoving(input, moveCount));
	}

	public boolean isNotFinish(ProgressMap progressMap) {
		return bridge.getBridgeSize() != progressMap.getMapSize() || progressMap.isMoveFailed();
	}

	public ProgressMap retry() {
		repeatCount++;
		return new ProgressMap();
	}

	public int getRepeatCount() {
		return repeatCount;
	}
}
