package bridge.controller;

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
		bridgeGame.makeBridge(inputController.getBridgeSize());
		playGame();
		outputView.printResult(bridgeGame.getMap(), bridgeGame.getResult());
	}

	private void playGame() {
		do {
			bridgeGame.setUpRound();
			playRound();
		} while (isKeepGaming());
	}

	private void playRound() {
		for (String stairs : bridgeGame.getBridges()) {
			bridgeGame.move(stairs, inputController.getStairs());
			outputView.printMap(bridgeGame.getMap());
			if (!bridgeGame.isRightStairs()) {
				bridgeGame.changeResultToFail();
				break;
			}
		}
	}

	private boolean isKeepGaming() {
		if (bridgeGame.isLose()) {
			return bridgeGame.retry(inputController.getExitOption());
		}
		return false;
	}
}

