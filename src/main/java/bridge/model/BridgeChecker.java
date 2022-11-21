package bridge.model;

import java.util.List;

public class BridgeChecker {
	public static boolean isMovableLocation(List<String> bridge, String moveCommand,
		int currentStep) {
		return currentStep != bridge.size() && bridge.get(currentStep).equals(moveCommand);
	}

	public static boolean isGameClear(List<String> bridge, int currentStep) {
		return bridge.size() == currentStep;
	}
}
