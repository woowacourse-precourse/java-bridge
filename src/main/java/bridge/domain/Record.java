package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {
	private static final String MAP_START = "[ ";
	private static final String MAP_BETWEEN = "| ";
	private static final String MAP_END = "]";
	private static final String UP = "U";
	private static final String DOWN = "D";
	private static final String SUCCESS = "O";
	private static final String FAIL = "X";
	private static final int STEP_RESULT_INDEX = 1;
	private static final int STEP_WHERE_INDEX = 0;
	private final List<List<String>> result = new ArrayList<>();

	public void recordOneMove(String move, Boolean moveResult) {
		if (moveResult == true) {
			result.add(List.of(move, SUCCESS));
		}
		if (moveResult == false) {
			result.add(List.of(move, FAIL));
		}
	}

	public String getMap() {
		return getPartOfBridge(UP) + "\n" + getPartOfBridge(DOWN);
	}

	private String getPartOfBridge(String upOrDown) {
		String map = "";
		map = map + MAP_START;
		map = map + getMapInfo(upOrDown);
		map = map + MAP_END;
		return map;
	}

	private String getMapInfo(String upOrDown) {
		String map = "";
		for (int i = 0; i < result.size(); i++) {
			map = map + getOXorBlank(result.get(i), upOrDown) + " ";
			map = map + getMapBetween(i);
		}
		return map;
	}

	private String getMapBetween(int i) {
		if (i != getLastStepIndex()) {
			return MAP_BETWEEN;
		}
		return "";
	}

	private String getOXorBlank(List<String> oneStep, String upOrDown) {
		if (oneStep.get(STEP_WHERE_INDEX).equals(upOrDown)) {
			return oneStep.get(STEP_RESULT_INDEX);
		}
		return " ";
	}

	public List<List<String>> getResult() {
		return result;
	}

	public Boolean isSuccess() {
		return result.get(getLastStepIndex()).get(STEP_RESULT_INDEX).equals(SUCCESS);
	}

	private int getLastStepIndex() {
		return result.size() - 1;
	}
}
