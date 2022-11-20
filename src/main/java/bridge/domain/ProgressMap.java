package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgressMap {
	private static final String MOVE_FAILED_VALUE = " X ";
	private static final String MOVE_SUCCESS_VALUE = " O ";
	private static final String NO_MOVE_VALUE = "   ";
	private static final String MOVE_UP_VALUE = "U";
	private static final String MOVE_DOWN_VALUE = "D";
	private final List<List<String>> progressMap;

	public ProgressMap() {
		progressMap = new ArrayList<>();
		progressMap.add(new ArrayList<>());
		progressMap.add(new ArrayList<>());
	}

	public boolean isMoveFailed() {
		return (progressMap.get(0).contains(MOVE_FAILED_VALUE) || progressMap.get(1).contains(MOVE_FAILED_VALUE));
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
		if (moving.equals(MOVE_UP_VALUE)) {
			correctMoveUp();
		}
		if (moving.equals(MOVE_DOWN_VALUE)) {
			correctMoveDown();
		}
	}

	private void correctMoveUp() {
		progressMap.get(0).add(MOVE_SUCCESS_VALUE);
		progressMap.get(1).add(NO_MOVE_VALUE);
	}

	private void correctMoveDown() {
		progressMap.get(0).add(NO_MOVE_VALUE);
		progressMap.get(1).add(MOVE_SUCCESS_VALUE);
	}

	private void incorrectMove(String moving) {
		if (moving.equals(MOVE_UP_VALUE)) {
			incorrectMoveUp();
		}
		if (moving.equals(MOVE_DOWN_VALUE)) {
			incorrectMoveDown();
		}
	}

	private void incorrectMoveUp() {
		progressMap.get(0).add(MOVE_FAILED_VALUE);
		progressMap.get(1).add(NO_MOVE_VALUE);
	}

	private void incorrectMoveDown() {
		progressMap.get(0).add(NO_MOVE_VALUE);
		progressMap.get(1).add(MOVE_FAILED_VALUE);
	}

	public int getMapSize() {
		return progressMap.get(0).size();
	}

	public List<List<String>> getProgressMap() {
		return progressMap;
	}
}
