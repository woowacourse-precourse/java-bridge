package bridge.model;

import java.util.List;

// todo : 빠뜨린 조건이 있는지 다시 생각해볼것!
public class BridgeChecker {
	public static boolean isMovableLocation(List<String> bridge, String moveCommand, int gameTurn) {
		return isNotFinish(bridge, gameTurn) && isMovable(bridge, moveCommand, gameTurn);
	}

	public static boolean isEndGame(List<String> bridge, int gameTurn) {
		return !isNotFinish(bridge, gameTurn);
	}

	private static boolean isNotFinish(List<String> bridge, int gameTurn) {
		return bridge.size() != gameTurn;
	}

	private static boolean isMovable(List<String> bridge, String moveCommand, int currentStep) {
		return currentStep != bridge.size() && bridge.get(currentStep).equals(moveCommand);
	}
}
