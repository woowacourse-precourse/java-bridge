package bridge.domain;

import bridge.Util;

import java.util.List;
import java.util.stream.IntStream;

public class BridgeGameCheck {
	public static boolean isMatchDirection(BridgeGame bridgeGame) {
		int size = bridgeGame.getPlayerDirections().size();
		List<String> subAnswerBridge = bridgeGame.getAnswerDirections().subList(0, size);
		return subAnswerBridge.equals(bridgeGame.getPlayerDirections());
	}

	public static boolean isGameLoss(BridgeGame bridgeGame){
		return isNotFinish(bridgeGame) || !isAllMatch(bridgeGame);
	}

	public static boolean isNotFinish(BridgeGame bridgeGame) {
		return bridgeGame.getPlayerDirections().size() != bridgeGame.getAnswerDirections().size();
	}

	private static boolean isAllMatch(BridgeGame bridgeGame) {
		int count = (int) IntStream.range(0, bridgeGame.getAnswerDirections().size())
				.filter(idx -> Util.valueEqualCheck(bridgeGame.getAnswerDirections(), bridgeGame.getPlayerDirections(), idx))
				.count();
		return count == bridgeGame.getAnswerDirections().size();
	}

	public static boolean isGameWin(BridgeGame bridgeGame) {
		return !isNotFinish(bridgeGame) && isAllMatch(bridgeGame);
	}
}
