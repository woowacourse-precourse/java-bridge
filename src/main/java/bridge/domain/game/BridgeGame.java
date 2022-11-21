package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.map.BridgeMap;
import bridge.domain.player.BridgeSizeCommand;
import bridge.domain.player.CommandReader;
import bridge.domain.player.GameProceedCommand;
import bridge.view.input.InputCommandReader;

import java.util.HashMap;
import java.util.List;

public class BridgeGame {

	public static final String RESULT_SUCCESS = "성공";
	public static final String RESULT_FAIL = "실패";

	private String crossFailOrSuccess;
	private int trialCount;

	public void play(BridgeMaker bridgeMaker) {

		Bridge bridge = new Bridge((BridgeSizeCommand) InputCommandReader.read(CommandReader.BRIDGE_SIZE).command(), bridgeMaker);

		do {
			crossingTrial(bridge);
		} while (isTrialContinue());
	}

	private void crossingTrial(Bridge bridge) {
		trialCount++;
		List<String> bridgeNowCrossing = bridge.getBridgeToCross();
		CrossingBridge crossingBridge = CrossingBridge.over(bridgeNowCrossing);
		crossFailOrSuccess = crossingBridge.isCrossComplete();
	}

	private boolean isTrialContinue() {
		if (crossFailOrSuccess.equals(RESULT_SUCCESS) || GameProceedCommand.QUIT.equals(requestRetry().gameCommand())) {
			return false;
		}

		BridgeMap.clearBridgeDescription();
		return true;
	}

	private GameProceedCommand requestRetry() {
		return (GameProceedCommand) InputCommandReader.read(CommandReader.GAME_PROCEED).command();
	}

	public HashMap<String, Integer> getGameResult() {
		HashMap<String, Integer> gameResult = new HashMap<>();
		gameResult.put(crossFailOrSuccess, trialCount);
		return gameResult;
	}
}
