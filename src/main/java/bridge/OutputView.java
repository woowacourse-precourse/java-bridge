package bridge;

import bridge.enums.Command;
import bridge.enums.Format;
import bridge.enums.Map;
import bridge.enums.Message;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

	List<String> upperMap = new ArrayList<>();
	List<String> lowerMap = new ArrayList<>();

	public void printMap(int round, Bridge bridge, String movement) {
		movementUp(round, bridge, movement);
		movementDown(round, bridge, movement);
		formatting();
		ifBlocked(round);
	}

	public void movementUp(int round, Bridge bridge, String movement) {
		if (movement.equals(Command.UP.getValue())) {
			upperMap.add(bridge.getUpperBridge().get(round));
			lowerMap.add(Map.BLANK.getValue());
		}
	}

	public void movementDown(int round, Bridge bridge, String movement) {
		if (movement.equals(Command.DOWN.getValue())) {
			upperMap.add(Map.BLANK.getValue());
			lowerMap.add(bridge.getLowerBridge().get(round));
		}
	}

	public void formatting() {
		System.out.println(upperMap.toString().replaceAll(Format.COMMA.getValue(), Format.BAR.getValue()));
		System.out.println(lowerMap.toString().replaceAll(Format.COMMA.getValue(), Format.BAR.getValue()));
	}

	public void ifBlocked(int round) {
		if (upperMap.get(round).equals(Map.DIE.getValue()) || lowerMap.get(round).equals(Map.DIE.getValue())) {
			upperMap.clear();
			lowerMap.clear();
		}
	}

	public void printResult(boolean status, int gameTry) {
		if (status) {
			System.out.println(Message.RESULT_SUCCESS.getValue());
			System.out.println(Message.RESULT_TRY.getValue() + gameTry);
			return;
		}
		System.out.println(Message.RESULT_FAIL.getValue());
		System.out.println(Message.RESULT_TRY.getValue() + gameTry);
	}

	public void printStart() {
		System.out.println(Message.HEADER_START.getValue());
	}

	public void printRequestBridgeSize() {
		System.out.println(Message.REQUEST_BRIDGE_SIZE.getValue());
	}

	public void printRequestUpDown() {
		System.out.println(Message.REQUEST_MOVE.getValue());
	}

	public void printRequestRetry() {
		System.out.println(Message.REQUEST_RETRY.getValue());
	}
}
