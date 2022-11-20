package bridge.controller;

import java.util.List;

import bridge.model.service.BridgeGame;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame bridgeGame;
	private final InputController inputController;
	private final OutputView outputView;

	public GameController() {
		this.bridgeGame = new BridgeGame();
		this.inputController = new InputController();
		this.outputView = new OutputView();
	}

	public void run() {
		outputView.printStartMessage();
		List<String> bridges = bridgeGame.makeBridge(inputController.getBridgeSize());
		playGame(bridges);
		outputView.printResult(bridgeGame.getMap(), bridgeGame.getResult());
	}

	private void playGame(List<String> bridges) {
		do {
			bridgeGame.setUpRound();
			playRound(bridges);
		} while (isKeepGaming());
	}

	private void playRound(List<String> bridges) {
		for (String stairs : bridges) {
			printResultOfMove(stairs);
			if (!bridgeGame.isRightStairs()) {
				bridgeGame.changeResultToFail();
				break;
			}
		}
	}

	private void printResultOfMove(String stairs) {
		bridgeGame.move(stairs, inputController.getStairs());
		outputView.printMap(bridgeGame.getMap());
	}

	private boolean isKeepGaming() {
		if (bridgeGame.isLose()) {
			return bridgeGame.retry(inputController.getExitOption());
		}
		return false;
	}
}

