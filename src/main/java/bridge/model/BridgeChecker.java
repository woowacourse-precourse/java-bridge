package bridge.model;

import java.util.List;

// todo : 빠뜨린 조건이 있는지 다시 생각해볼 것!
public class BridgeChecker {
	public static boolean isMovableLocation(List<String> bridge, String moveCommand, int currentStep) {
		return currentStep != bridge.size() && bridge.get(currentStep).equals(moveCommand);
	}

	public static boolean isGameClear(List<String> bridge, int currentStep) {
		return bridge.size() == currentStep;
	}
}
