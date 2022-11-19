package bridge.service;

import java.util.List;

public class BridgeGame {

	public void move(List<String> currentBridgeState, String inputMoveCommand) {
		currentBridgeState.add(inputMoveCommand);
	}

	public boolean retry(String inputGameCommand) {
		if (inputGameCommand.equals("R")) {
			return true;
		}
		return false;
	}

	public boolean isAnswerBridge(List<String> bridge, List<String> currentBridgeState) {
		boolean state = true;
		for (int i = 0; i < bridge.size(); i++) {
			state = isNotAnswer(bridge, currentBridgeState, i);
		}
		return state;
	}

	private static boolean isNotAnswer(List<String> bridge, List<String> currentBridgeState, int i) {
		return !bridge.get(i).equals(currentBridgeState.get(i));
	}

}
