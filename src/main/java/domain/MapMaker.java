package domain;

import service.ViewController;

public class MapMaker {
	private ViewController view = new ViewController();
	private StringBuilder upperMap, lowerMap;
	private int index;

	public MapMaker() {
		upperMap = new StringBuilder();
		lowerMap = new StringBuilder();
		index = 0;
	}

	public boolean conditionCheck(String rightCondition) {
		String move = view.movingView();
		if (matchBridge(rightCondition, move)) {
			view.mapView(toString());
			return true;
		}
		view.mapView(toString());
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