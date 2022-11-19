package bridge.controller;

import java.util.List;

import bridge.model.GameResult;
import bridge.model.Map;
import bridge.model.Stairs;
import bridge.service.BridgeGame;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame bridgeGame;
	private final Map map;
	private final GameResult gameResult;
	private final OutputView outputView;

	public GameController() {
		this.bridgeGame = new BridgeGame();
		this.map = new Map();
		this.gameResult = new GameResult();
		this.outputView = new OutputView();
	}

	public void run() {
		outputView.printStartMessage();
		List<String> bridges = bridgeGame.setUpGame(InputController.getBridgeSize());
		playGame(bridges);
		outputView.printResult(map, gameResult);
	}

	private void playGame(List<String> bridges) {
		do {
			bridgeGame.setUpRound(gameResult, map);
			playRound(bridges);
		} while (isKeepGaming());
	}

	private void playRound(List<String> bridges) {
		for (String square : bridges) {
			if (!isRightStep(square)) {
				gameResult.changeResultToFail();
				break;
			}
		}
	}

	private boolean isRightStep(String square) {
		Stairs stairs = InputController.getStairs();
		List<String> footPrints = bridgeGame.move(stairs, square);
		map.drawMap(footPrints);
		outputView.printMap(map);
		return stairs.isEquals(square);
	}

	private boolean isKeepGaming() {
		if (gameResult.isGameLose()) {
			return bridgeGame.retry(InputController.getExitOption());
		}
		return false;
	}
}

