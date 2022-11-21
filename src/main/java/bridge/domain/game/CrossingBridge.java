package bridge.domain.game;

import bridge.domain.map.BridgeMap;
import bridge.domain.player.CommandReader;
import bridge.domain.player.MovementCommand;
import bridge.view.input.InputCommandReader;
import bridge.view.output.OutputView;

import java.util.List;

public class CrossingBridge {

	private final boolean crossComplete;

	private CrossingBridge(List<String> bridgeNowCrossing) {
		cross(bridgeNowCrossing);
		this.crossComplete = isCrossComplete(bridgeNowCrossing);
	}

	public static CrossingBridge over(List<String> bridgeNowCrossing) {
		return new CrossingBridge(bridgeNowCrossing);
	}

	private void cross(List<String> bridgeNowCrossing) {
		MovementCommand movementCommand = (MovementCommand) InputCommandReader.read(CommandReader.GAME_MOVEMENT).command();
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeNowCrossing);

		stepAhead(crossingDecision, bridgeNowCrossing);
		OutputView.withContentOf(ResultRendering.generatedBy(
				BridgeMap.depictedBy(crossingDecision, movementCommand)).getBridgeDescription(), false, false).ConsoleMessage();

		keepCrossing(crossingDecision, bridgeNowCrossing);
	}

	private void stepAhead(CrossingDecision crossingDecision, List<String> bridgeNowCrossing) {
		if (crossingDecision.isCrossable()) {
			bridgeNowCrossing.remove(0);
		}
	}

	private void keepCrossing(CrossingDecision crossingDecision, List<String> bridgeNowCrossing) {
		if (!crossingDecision.isCrossable() || isCrossComplete(bridgeNowCrossing)) {
			return;
		}
		cross(bridgeNowCrossing);
	}

	private boolean isCrossComplete(List<String> bridgeNowCrossing) {
		return (bridgeNowCrossing.isEmpty());
	}

	public String isCrossComplete() {
		if (crossComplete) {
			return BridgeGame.RESULT_SUCCESS;
		}
		return BridgeGame.RESULT_FAIL;
	}
}
