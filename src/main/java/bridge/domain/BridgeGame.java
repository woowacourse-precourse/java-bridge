package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final List<String> bridge;
	private int repeatCount;

	public BridgeGame(List<String> bridge) {
		this.bridge = bridge;
		this.repeatCount = 1;
	}

	public void move(String input, ProgressMap gameProgress) {
		int index = gameProgress.whatMapSize();
		gameProgress.updateProgressMap(input, isCorrectMove(input, index));
	}

	private boolean isCorrectMove(String input, int index) {
		return bridge.get(index).equals(input);
	}

	public boolean isClear(ProgressMap progressMap) {
		return bridge.size() == progressMap.whatMapSize() && !progressMap.isMoveFailed();
	}

	public int getBridgeSize() {
		return bridge.size();
	}

	public void retry() {
		repeatCount++;
	}

	public int getRepeatCount() {
		return repeatCount;
	}
}
