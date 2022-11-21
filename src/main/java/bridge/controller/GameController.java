package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.GameService;
import bridge.util.GameConst;
import bridge.view.OutputView;

public class GameController {
	private final BridgeGame bridgeGame;
	private final OutputView outputView;
	private final InputController inputController;
	private final GameService gameService;

	public GameController(BridgeGame bridgeGame, OutputView outputView,
		InputController inputController, GameService gameService) {
		this.bridgeGame = bridgeGame;
		this.outputView = outputView;
		this.inputController = inputController;
		this.gameService = gameService;
	}

	public void startApplication() {
		Integer bridgeSize = getBridgeSize();
		gameService.makeBridge(bridgeSize);
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

	private void printResult(Integer attemptCount, String userResult) {
		outputView.printFinalResultPhrase();
		outputView.printMap(gameService.getUserBridgeStatus());
		outputView.printResult(userResult, attemptCount);
	}

	private boolean restartGame(String userResult) {
		return userResult.equals(GameConst.FAIL) &&
			bridgeGame.retry(inputController.getUserRestartCommand());
	}

	private String startMove(Integer bridgeSize) {
		Integer currentLocation = 0;
		do {
			if (checkIsInvalidUserMove(currentLocation, inputController.getUserMoving()))
				return GameConst.FAIL;
			currentLocation++;
		} while (!currentLocation.equals(bridgeSize));
		return GameConst.SUCCESS;
	}

	private boolean checkIsInvalidUserMove(Integer currentLocation, String userLocation) {
		if (!bridgeGame.move(userLocation, currentLocation)) {
			printWrongUserMap(userLocation);
			return true;
		}
		printCorrectMap(userLocation);
		return false;
	}

	private void printCorrectMap(String userLocation) {
		outputView.printMap(gameService.saveUserCorrectSpace(userLocation));
	}

	private void printWrongUserMap(String userLocation) {
		outputView.printMap(gameService.saveUserWrongSpace(userLocation));
	}

}
