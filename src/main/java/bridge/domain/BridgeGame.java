package bridge.domain;

import static bridge.domain.State.*;

public class BridgeGame {
	private final Bridge bridge;
	private State state;
	private int repeatCount;

	public BridgeGame(Bridge bridge) {
		this.bridge = bridge;
		this.repeatCount = 1;
		this.state = PLAY;
	}

	public void move(String input, ProgressMap gameProgress) {
		int moveCount = gameProgress.getMapSize();
		boolean isMoveSuccess = bridge.isCorrectMoving(input, moveCount);
		gameProgress.updateProgressMap(input, isMoveSuccess);
		changeState(isMoveSuccess, gameProgress);
	}

	private void changeState(boolean isMoveSuccess, ProgressMap progressMap) {
		if (isMoveSuccess && bridge.getBridgeSize() == progressMap.getMapSize()) {
			state = CLEAR;
		}
		if (!isMoveSuccess) {
			state = MOVE_FAILED;
		}
	}

	public boolean isNotFinish(ProgressMap progressMap) {
		return bridge.getBridgeSize() != progressMap.getMapSize() || progressMap.isMoveFailed();
	}

	public ProgressMap retry(boolean userChoice, ProgressMap progressMap) {
		if (userChoice) {
			this.repeatCount++;
			state = PLAY;
			return new ProgressMap();
		}
		state = FAILED_CLEAR;
		return progressMap;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

	public State getState() {
		return state;
	}
}
