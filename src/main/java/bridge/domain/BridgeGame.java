package bridge.domain;

import java.util.List;

public class BridgeGame {
	private final List<String> bridge;
	private int repeatCount;

	public BridgeGame(List<String> bridge) {
		this.bridge = bridge;
		this.repeatCount = 1;
	}

	public void move(String input, ProgressMap gameProgress) {
		int index = gameProgress.getMapSize();
		gameProgress.updateProgressMap(input, isCorrectMove(input, index));
	}

	private boolean isCorrectMove(String input, int index) {
		return bridge.get(index).equals(input);
	}

	public boolean isNotFinish(ProgressMap progressMap) {
		return bridge.size() != progressMap.getMapSize() || progressMap.isMoveFailed();
	}

	public int getBridgeSize() {
		return bridge.size();
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
