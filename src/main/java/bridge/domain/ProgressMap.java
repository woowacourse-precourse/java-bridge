package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgressMap {
	private static final int MOVE_UP_SEQUENCE = 0;
	private static final int MOVE_DOWN_SEQUENCE = 1;
	private final List<List<String>> progressMap;

	public ProgressMap() {
		progressMap = new ArrayList<>();
		progressMap.add(new ArrayList<>());
		progressMap.add(new ArrayList<>());
	}

	public void updateProgressMap(String moving, boolean isCorrectMove) {
		List<String> result = MoveResult.createMoveResult(moving, isCorrectMove);
		String moveUpResult = result.get(MOVE_UP_SEQUENCE);
		String moveDownResult = result.get(MOVE_DOWN_SEQUENCE);
		progressMap.get(MOVE_UP_SEQUENCE).add(moveUpResult);
		progressMap.get(MOVE_DOWN_SEQUENCE).add(moveDownResult);
	}

	public int getMapSize() {
		return progressMap.get(0).size();
	}

	public List<List<String>> getProgressMap() {
		return progressMap;
	}
}
