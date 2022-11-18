package bridge.domain.game;

import bridge.domain.player.MovementCommand;
import bridge.domain.result.ResultDescription;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class CrossingBridge {

	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String ENTER = "\n";

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
			OutputView.printGameInfo(ResultDescription.generatedBy(crossingDecision, movementCommand).getBridgeDescription() + ENTER);

		} while (isCrossToContinue(bridgeNowCrossing));
	}

	private void stepAhead(CrossingDecision crossingDecision, List<String> bridgeNowCrossing) {
		if (crossingDecision.isCrossable()) {
			bridgeNowCrossing.remove(0);
		}
	}

	private boolean isCrossToContinue(List<String> bridgeNowCrossing) {
		return !(ResultDescription.getBridgeDescription().contains("X") || isCompleteCrossing(bridgeNowCrossing));
	}

	private boolean isCompleteCrossing(List<String> bridgeNowCrossing) {
		return (bridgeNowCrossing.isEmpty());
	}

	public String isCrossComplete() {
		if (crossComplete) {
			return "성공";
		}
		return "실패";
	}
}
