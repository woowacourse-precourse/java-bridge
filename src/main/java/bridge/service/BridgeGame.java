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
		for (int i = 0; i < bridge.size(); i++) {
			if (!bridge.get(i).equals(currentBridgeState.get(i))) {
				return false;
			}
		}
		return true;
	}

}
