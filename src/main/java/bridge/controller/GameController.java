package bridge.controller;

import static bridge.util.Constants.*;

import java.util.HashMap;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.service.PauseGame;
import bridge.view.OutputView;

public class GameController {
	private int bridgeSize;
	private Bridge bridge;
	private HashMap<String, String> status;

	public GameController() {
		identifyBridgeSize();
		constructBridge();
		guessCorrectBridge();
		showFinalResult();
	}

	private void identifyBridgeSize() {
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
		if (PauseGame.isNotPaused()) {
			return;
		}
		selectRestartOrQuit(bridgeGame);
	}

	private static void selectRestartOrQuit(BridgeGame bridgeGame) {
		String userSelectCommand = InputController.getGameCommand();
		selectRestart(bridgeGame, userSelectCommand);
		selectQuit(bridgeGame, userSelectCommand);
	}

	private static void selectRestart(BridgeGame bridgeGame, String userSelectCommand) {
		if (userSelectCommand.equals(RESTART)) {
			bridgeGame.retry();
			OutputView.resetPrintStatus();
		}
	}

	private static void selectQuit(BridgeGame bridgeGame, String userSelectCommand) {
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
	}
}
