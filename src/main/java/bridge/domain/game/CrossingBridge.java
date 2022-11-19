package bridge.domain.game;

import bridge.domain.player.CommandReader;
import bridge.domain.player.MovementCommand;
import bridge.domain.result.ResultRendering;
import bridge.view.input.InputCommandReader;
import bridge.view.output.OutputView;

import java.util.List;

public class CrossingBridge {

	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

	private final boolean crossComplete;

	public CrossingBridge(List<String> bridgeNowCrossing) {
		cross(bridgeNowCrossing);
		this.crossComplete = isCrossComplete(bridgeNowCrossing);
	}

	public static CrossingBridge over(List<String> bridgeNowCrossing) {
		return new CrossingBridge(bridgeNowCrossing);
	}

	private void cross(List<String> bridgeNowCrossing) {
		do {
			OutputView.withContentOf(REQUEST_MOVEMENT, true, false).ConsoleMessage();
			MovementCommand movementCommand = (MovementCommand) InputCommandReader.read(CommandReader.GAME_MOVEMENT).command();
			CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeNowCrossing);
			stepAhead(crossingDecision, bridgeNowCrossing);
			OutputView.withContentOf(
					ResultRendering.generatedBy(crossingDecision, movementCommand).getBridgeDescription(), false, false)
					.ConsoleMessage();
		} while (isCrossContinue(bridgeNowCrossing));
	}

	private void stepAhead(CrossingDecision crossingDecision, List<String> bridgeNowCrossing) {
		if (crossingDecision.isCrossable()) {
			bridgeNowCrossing.remove(0);
		}
	}

	private boolean isCrossContinue(List<String> bridgeNowCrossing) {
		return !(ResultRendering.getBridgeDescription().contains("X") || isCrossComplete(bridgeNowCrossing));
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
