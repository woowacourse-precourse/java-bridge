package domain;

import service.InputView;
import service.OutputView;

/**
 * 사용자에게 입력을 받고, 
 * 사용자에게 게임 진행 상황과 결과를 출력여
 * 이동중인 맵을 생성한다.
 */
public class MapMaker {
	private InputView input = new InputView();
	private OutputView output = new OutputView();

	private StringBuilder upperMap, lowerMap;
	private int index;

	public MapMaker() {
		upperMap = new StringBuilder();
		lowerMap = new StringBuilder();

		index = 0;
	}

	public boolean conditionCheck(String rightCondition) {
		output.printGameMessage("MOVING");
		String move = input.readMoving();

		if (matchBridge(rightCondition, move)) {
			output.printMap(toString());
			return true;
		}

		output.printMap(toString());
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