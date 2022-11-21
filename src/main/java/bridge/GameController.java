package bridge;

import static bridge.Constants.*;

import java.util.HashMap;

public class GameController {
	private int bridgeSize;
	private Bridge bridge;
	private HashMap<String, String> status;

	public GameController() {
		getBridgeSize();
		constructBridge();
		guessCorrectBridge();
		showFinalResult();
	}

	private void getBridgeSize() {
		OutputView.printStartGameMessage();
		bridgeSize = InputController.getBridgeSize();
		OutputView.printNewLine();
	}

	private void constructBridge() {
		BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
		bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
	}

	private void guessCorrectBridge() {
		BridgeGame bridgeGame = new BridgeGame(bridge, bridgeSize);
		while (IsPlayingGame(bridgeGame)) {
			reviewMovement(bridgeGame);
			OutputView.printStatus(status);
			examineFailure(bridgeGame);
		}
	}

	private boolean IsPlayingGame(BridgeGame bridgeGame) {
		return !bridgeGame.isEnd();
	}

	private void reviewMovement(BridgeGame bridgeGame) {
		String userSelectCell = InputController.getMoving();
		String bridgeLetter = bridgeGame.getBridgeLetter();
		bridgeGame.move(userSelectCell);
		status = OutputView.printMap(userSelectCell, bridgeLetter);
	}

	private void examineFailure(BridgeGame bridgeGame) {
		if (Pause.isNotPaused()) {
			return;
		}
		selectRestartOrQuit(bridgeGame);
	}

	private static void selectRestartOrQuit(BridgeGame bridgeGame) {
		String userSelectCommand = InputController.getGameCommand();
		if (userSelectCommand.equals(RESTART)) {
			bridgeGame.retry();
			OutputView.resetPrintStatus();
		}
		if (userSelectCommand.equals(QUIT)) {
			bridgeGame.end();
		}
	}

	private void showFinalResult() {
		OutputView.printFinalGameResultMessage();
		printResultStatus();
		OutputView.printGameReportMessage();
		OutputView.printTotalTryCountMessage();
	}

	private void printResultStatus() {
		status = OutputView.printResult();
		OutputView.printStatus(status);
		OutputView.printNewLine();
	}
}
