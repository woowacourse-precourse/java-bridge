package bridge.domain.game;

import bridge.domain.player.MovementCommand;
import bridge.domain.result.ResultRendering;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class CrossingBridge {

	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

	private final boolean crossComplete;

	public CrossingBridge(InputView inputView, List<String> bridgeNowCrossing) {
		crossingTrial(inputView, bridgeNowCrossing);
		this.crossComplete = isCompleteCrossing(bridgeNowCrossing);
	}

	public static CrossingBridge over(InputView inputView, List<String> bridgeNowCrossing) {
		return new CrossingBridge(inputView, bridgeNowCrossing);
	}

	private void crossingTrial(InputView inputView, List<String> bridgeNowCrossing) {
		do {
			OutputView.printRequest(REQUEST_MOVEMENT);
			MovementCommand movementCommand = inputView.readMovement();
			CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeNowCrossing);
			stepAhead(crossingDecision, bridgeNowCrossing);
			OutputView.printGameInfo(ResultRendering.generatedBy(crossingDecision, movementCommand).getBridgeDescription());

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
