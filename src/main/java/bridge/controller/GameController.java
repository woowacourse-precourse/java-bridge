package bridge.controller;

import java.util.List;

import bridge.model.service.BridgeGame;
import bridge.model.validation.Stairs;
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
		for (String square : bridges) {
			boolean isRightStep = checkMapChange(square, inputController.getStairs());
			if (!isRightStep) {
				bridgeGame.changeResultToFail();
				break;
			}
		}
	}

	private boolean checkMapChange(String square, Stairs stairs) {
		boolean isEquals = stairs.isEquals(square);
		bridgeGame.move(stairs, isEquals);
		outputView.printMap(bridgeGame.getMap());
		return isEquals;
	}

	private boolean isKeepGaming() {
		if (bridgeGame.isLose()) {
			return bridgeGame.retry(inputController.getExitOption());
		}
		return false;
	}
}

