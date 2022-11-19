package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgressMap {
	private final List<List<String>> progressMap;

	public ProgressMap() {
		progressMap = new ArrayList<>();
		progressMap.add(new ArrayList<>());
		progressMap.add(new ArrayList<>());
	}

	public boolean isMoveFailed() {
		return (progressMap.get(0).contains(" X ") || progressMap.get(1).contains(" X "));
	}

	public void updateProgressMap(String moving, boolean isCorrectMove) {
		if (isCorrectMove) {
			correctMove(moving);
		}
		if (!isCorrectMove) {
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

	public int whatMapSize() {
		return progressMap.get(0).size();
	}

	public List<List<String>> getProgressMap() {
		return progressMap;
	}
}
