package bridge.controller;

import bridge.service.BridgeGame;
import bridge.util.GameConst;
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
		Integer bridgeSize = getBridgeSize();
		bridgeGame.makeBridge(bridgeSize);
		startGame(bridgeSize);
	}

	private Integer getBridgeSize() {
		inputController.startGame();
		Integer bridgeSize = inputController.getBridgeSize();
		return bridgeSize;
	}

	private void startGame(Integer bridgeSize) {
		Integer attemptCount = 0;
		String userResult;
		do {
			attemptCount++;
			userResult = startMove(bridgeSize);
		} while (restartGame(userResult));
		printResult(attemptCount, userResult);
	}

	private String startMove(Integer bridgeSize) {
		Integer currentLocation = 0;
		boolean validMove;
		do {
			validMove = bridgeGame.move(inputController.getUserMoving(), currentLocation);
			outputView.printMap(bridgeGame.getUserBridgeStatus());
			currentLocation++;
		} while (validMove && !currentLocation.equals(bridgeSize));
		return getResult(validMove);
	}

	private String getResult(boolean validMove) {
		if (!validMove) {
			return GameConst.FAIL;
		}
		return GameConst.SUCCESS;
	}

	private void printResult(Integer attemptCount, String userResult) {
		outputView.printFinalResultPhrase();
		outputView.printMap(bridgeGame.getUserBridgeStatus());
		outputView.printResult(userResult, attemptCount);
	}

	private boolean restartGame(String userResult) {
		return userResult.equals(GameConst.FAIL) &&
			bridgeGame.retry(inputController.getUserRestartCommand());
	}

}
