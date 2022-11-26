package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.OutputView;

public class GameController {
	private final BridgeGame bridgeGame;
	private final OutputView outputView;
	private final InputController inputController;

	public GameController(BridgeGame bridgeGame, OutputView outputView,
		InputController inputController) {
		this.bridgeGame = bridgeGame;
		this.outputView = outputView;
		this.inputController = inputController;
	}

	public void startApplication() {
		setGame();
		startGame();
	}

	private void setGame() {
		outputView.printGameStart();
		Integer bridgeSize = inputController.getBridgeSize();
		bridgeGame.makeBridge(bridgeSize);
	}

	private void startGame() {
		do {
			bridgeGame.attemptCountPlusOne();
			startMove();
		} while (restartGame());
		printResult();
	}

	private void startMove() {
		do {
			bridgeGame.move(inputController.getUserMoving());
			outputView.printMap(bridgeGame.getUserBridgeStatus());
		} while (bridgeGame.checkIsEndSituation());
		bridgeGame.organizeResult();
	}

	private void printResult() {
		outputView.printFinalResultPhrase();
		outputView.printMap(bridgeGame.getUserBridgeStatus());
		outputView.printResult(bridgeGame.findFinalResultToString());
	}

	private boolean restartGame() {
		return bridgeGame.isFail() && bridgeGame.retry(inputController.getUserRestartCommand());
		//여기서 만약 isFail 이 false 면, retry() 함수 호출하지도 않고 나감
	}

}
