package domain;

import service.InputView;
import service.OutputView;

public class MapMaker {
	private InputView in = new InputView();
	private OutputView out = new OutputView();

	private StringBuilder upperMap, lowerMap;
	private int index;

	public MapMaker() {
		upperMap = new StringBuilder();
		lowerMap = new StringBuilder();

		index = 0;
	}

	public boolean conditionCheck(String rightCondition) {
		out.printGameMessage("MOVING");
		String move = in.readMoving();

		if (matchBridge(rightCondition, move)) {
			out.printMap(toString());
			return true;
		}

		out.printMap(toString());
		return false;
	}

	private boolean matchBridge(String rightCondition, String move) {
		if (rightCondition.equals(move)) {
			upOrDownCheck(move, true);
			return true;
		}

		upOrDownCheck(move, false);
		return false;
	}

	private void upOrDownCheck(String move, boolean condition) {
		setPartition();

		if (move.equals("U")) {
			upperMap.append(setCondition(condition));
			lowerMap.append(BridgeCondition.EMPTY.getCondition());
			return;
		}

		upperMap.append(BridgeCondition.EMPTY.getCondition());
		lowerMap.append(setCondition(condition));
	}

	private String setCondition(boolean condition) {
		if (condition) {
			return BridgeCondition.RIGHT.getCondition();
		}

		return BridgeCondition.WRONG.getCondition();
	}

	private void setPartition() {
		if (index != 0) {
			upperMap.append("|");
			lowerMap.append("|");
		}

		index++;
	}

	public String toString() {
		return "[" + upperMap + "]\n" + "[" + lowerMap + "]";
	}
}
