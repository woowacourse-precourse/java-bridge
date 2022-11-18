package bridge.controller;

import java.util.List;

import bridge.model.GameResult;
import bridge.model.Map;
import bridge.model.Stairs;
import bridge.service.BridgeGame;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame bridgeGame = new BridgeGame();
	private final OutputView outputView = new OutputView();

	public void run() {
		GameResult gameResult = new GameResult();
		List<String> bridges = bridgeGame.setUpGame(InputController.getBridgeSize());
		playRound(bridges, gameResult);
		outputView.printResult(gameResult);
	}

	private void playRound(List<String> bridges, GameResult gameResult) {
		bridgeGame.setUpRound(gameResult);
		Map map = new Map();
		for (String square : bridges) {
			if (!isSuccess(map, square)) {
				gameResult.changeResultToFail();
				isRetry(bridges, gameResult, map);
				break;
			}
		}
		outputView.printEndMessage();
		outputView.printMap(map);
	}

	private void isRetry(List<String> bridges, GameResult gameResult, Map map) {
		if (bridgeGame.retry(InputController.getExitOption())) {
			playRound(bridges, gameResult);
		}
		outputView.printEndMessage();
		outputView.printMap(map);
	}

	private boolean isSuccess(Map map, String square) {
		Stairs stairs = InputController.getStairs();
		boolean isEqual = stairs.isEquals(square);
		map.drawMap(bridgeGame.move(stairs.getNumber(), isEqual));
		outputView.printMap(map);
		return isEqual;
	}

}

