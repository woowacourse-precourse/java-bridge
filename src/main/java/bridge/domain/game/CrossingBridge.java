package bridge.domain.game;

import bridge.domain.player.MovementCommand;
import bridge.domain.result.ResultRendering;
import bridge.view.input.InputCommandReader;
import bridge.view.output.OutputView;

import java.util.List;

public class CrossingBridge {

	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

	private final boolean crossComplete;

	public CrossingBridge(List<String> bridgeNowCrossing) {
		crossingTrial(bridgeNowCrossing);
		this.crossComplete = isCompleteCrossing(bridgeNowCrossing);
	}

	public static CrossingBridge over(List<String> bridgeNowCrossing) {
		return new CrossingBridge(bridgeNowCrossing);
	}

	private void crossingTrial(List<String> bridgeNowCrossing) {
		do {
			OutputView.withContentOf(REQUEST_MOVEMENT, true, false).ConsoleMessage();
			MovementCommand movementCommand = (MovementCommand) InputCommandReader.read("Movement").command();
			CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeNowCrossing);
			stepAhead(crossingDecision, bridgeNowCrossing);
			OutputView.withContentOf(ResultRendering.generatedBy(crossingDecision, movementCommand).getBridgeDescription(), false, false).ConsoleMessage();

		} while (isCrossToContinue(bridgeNowCrossing));
	}

	private void stepAhead(CrossingDecision crossingDecision, List<String> bridgeNowCrossing) {
		if (crossingDecision.isCrossable()) {
			bridgeNowCrossing.remove(0);
		}
	}

	private boolean isCrossToContinue(List<String> bridgeNowCrossing) {
		return !(ResultRendering.getBridgeDescription().contains("X") || isCompleteCrossing(bridgeNowCrossing));
	}

	private boolean isCompleteCrossing(List<String> bridgeNowCrossing) {
		return (bridgeNowCrossing.isEmpty());
	}

	public String isCrossComplete() {
		if (crossComplete) {
			return BridgeGame.RESULT_SUCCESS;
		}
		return BridgeGame.RESULT_FAIL;
	}
}
