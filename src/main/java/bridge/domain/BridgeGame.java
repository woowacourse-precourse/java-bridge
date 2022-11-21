package bridge.domain;

import java.util.List;

public class BridgeGame {
	private final Bridge bridge;
	private int repeatCount;

	public BridgeGame(Bridge bridge) {
		this.bridge = bridge;
		this.repeatCount = 1;
	}

	public void move(String input, ProgressMap gameProgress) {
		int moveCount = gameProgress.getMapSize();
		gameProgress.updateProgressMap(input, isCorrectMove(input, moveCount));
	}

	private boolean isCorrectMove(String input, int moveCount) {
		return bridge.isCorrectMoving(input, moveCount);
	}

	public boolean isNotFinish(ProgressMap progressMap) {
		return bridge.getBridgeSize() != progressMap.getMapSize() || progressMap.isMoveFailed();
	}

	public int getBridgeSize() {
		return bridge.getBridgeSize();
	}

	public boolean retry(boolean userChoice) {
		if (userChoice) {
			repeatCount++;
			return true;
		}
		return false;
	}

	public int getRepeatCount() {
		return repeatCount;
	}
}
