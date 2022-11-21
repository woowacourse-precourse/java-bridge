package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.command.MoveCommand;

public class ProgressMap {
	private static final String MOVE_FAILED_VALUE = "X";
	private static final String MOVE_SUCCESS_VALUE = "O";
	private static final String NO_MOVE_VALUE = " ";
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
		if (moving.equals(MoveCommand.MOVE_UP.getValue())) {
			correctMoveUp();
		}
		if (moving.equals(MoveCommand.MOVE_DOWN.getValue())) {
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
		if (moving.equals(MoveCommand.MOVE_UP.getValue())) {
			incorrectMoveUp();
		}
		if (moving.equals(MoveCommand.MOVE_DOWN.getValue())) {
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
