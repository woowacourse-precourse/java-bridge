package bridge.model;

import java.util.List;

// todo : 빠뜨린 조건이 있는지 다시 생각해볼것!
public class BridgeChecker {
	public static boolean isNotMovableStep(List<String> bridge, String moveCommand, int gameTurn) {
		// 이동할 수 없다면 true, 이동할 수 있다면 false
		return isFinish(bridge, gameTurn) || isNotMovable(bridge, moveCommand, gameTurn);
	}

	public static boolean isEndGame(List<String> bridge, int gameTurn) {
		return isFinish(bridge, gameTurn);
	}

	private static boolean isFinish(List<String> bridge, int gameTurn) {
		return bridge.size() == gameTurn;
	}

	private static boolean isNotMovable(List<String> bridge, String moveCommand, int gameTurn) {
		return !bridge.get(gameTurn).equals(moveCommand);
	}
}
