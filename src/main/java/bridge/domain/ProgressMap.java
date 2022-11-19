package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgressMap {
	private final List<List<String>> progressMap;
	private final int clearSize;
	private boolean clearFailed;

	public ProgressMap(int bridgeSize) {
		progressMap = new ArrayList<>();
		progressMap.add(new ArrayList<>());
		progressMap.add(new ArrayList<>());
		clearSize = bridgeSize;
	}

	public boolean isClear() {
		return clearSize == progressMap.get(0).size();
	}

	public void updateProgressMap(String moving, boolean isCorrectMove) {
		if (isCorrectMove) {
			correctMove(moving);
		}
		if (!isCorrectMove) {
			clearFailed = true;
			incorrectMove(moving);
		}
	}

	private void correctMove(String moving) {
		if (moving.equals("U")) {
			correctMoveUp();
		}
		if (moving.equals("D")) {
			correctMoveDown();
		}
	}

	private void correctMoveUp() {
		progressMap.get(0).add(" O ");
		progressMap.get(1).add("   ");
	}

	private void correctMoveDown() {
		progressMap.get(0).add("   ");
		progressMap.get(1).add(" O ");
	}

	private void incorrectMove(String moving) {
		if (moving.equals("U")) {
			incorrectMoveUp();
		}
		if (moving.equals("D")) {
			incorrectMoveDown();
		}
	}

	private void incorrectMoveUp() {
		progressMap.get(0).add(" X ");
		progressMap.get(1).add("   ");
	}

	private void incorrectMoveDown() {
		progressMap.get(0).add("   ");
		progressMap.get(1).add(" X ");
	}

	public boolean isClearFailed() {
		return clearFailed;
	}

	public int whatMapSize() {
		return progressMap.get(0).size();
	}

	public List<List<String>> getProgressMap() {
		return progressMap;
	}
}
