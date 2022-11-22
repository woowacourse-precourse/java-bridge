package bridge.controller;

import bridge.common.utils.ExceptionHandler;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
	public void run() {
		printBridgeGameStart();
		BridgeGame bridgeGame = initializeBridgeGame();
		playBridgeGame(bridgeGame);
		printFinalMap();
		printPlayedInfo(bridgeGame);
	}

	private void printBridgeGameStart() {
		OutputView.printBridgeGameStart();
	}

	private BridgeGame initializeBridgeGame() {
		return ExceptionHandler.getCorrectInput(() -> {
			OutputView.printInputBridgeSize();
			int bridgeSize = InputView.readBridgeSize();
			return new BridgeGame(bridgeSize);
		});
	}

	private void playBridgeGame(BridgeGame bridgeGame) {
		while (isGameProcessing(bridgeGame)) {
			String moving = getUserMoving();

			bridgeGame.move(moving);
			OutputView.printMap(BridgeGameResult.getMoveCount());

			afterMoveProcess(bridgeGame);
		}
	}

	private boolean isGameProcessing(BridgeGame bridgeGame) {
		return bridgeGame.isGameProcessing();
	}

	private String getUserMoving() {
		return ExceptionHandler.getCorrectInput(() -> {
			OutputView.printInputMoving();
			return InputView.readMoving();
		});
	}

	private void afterMoveProcess(BridgeGame bridgeGame) {
		if (isGameEnd(bridgeGame)) {
			if (isGameFailed(bridgeGame)) {
				OutputView.printWhetherRestartOrNot();
				restartProcess(bridgeGame, isUserSelectRestart());
			}
		}
	}

	private boolean isGameEnd(BridgeGame bridgeGame) {
		return bridgeGame.isGameEnd();
	}

	private boolean isGameFailed(BridgeGame bridgeGame) {
		return bridgeGame.isGameFailed();
	}

	private boolean isUserSelectRestart() {
		return InputView.readGameCommand().equals("R");
	}

	private void restartProcess(BridgeGame bridgeGame, boolean isUserSelectRestart) {
		if (isUserSelectRestart) {
			bridgeGame.retry();
		}
	}

	private void printFinalMap() {
		OutputView.printFinalGameResult();
		OutputView.printMap(BridgeGameResult.getMoveCount());
	}

	private void printPlayedInfo(BridgeGame bridgeGame) {
		String whetherGameSuccess = bridgeGame.getFinalGameStatus();
		int totalTryCount = bridgeGame.getTotalTryCount();

		OutputView.printResult(whetherGameSuccess, totalTryCount);
	}
}
