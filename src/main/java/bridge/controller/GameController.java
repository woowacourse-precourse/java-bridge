package bridge.controller;

import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;
import bridge.util.Logger;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private BridgeGame bridgeGame;

	public void run() {
		try {
			gameStart();
			crossingBridge();
			outputView.printResult(bridgeGame);
		} catch (IllegalArgumentException | NullPointerException exception) {
			Logger.error(exception.getMessage());
		}
	}

	private void gameStart() {
		outputView.printStart();
		outputView.printRequestBridgeSize();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
	}

	private void crossingBridge() {
		BridgeResult bridgeResult = new BridgeResult();

		do {
			String moveInput = requestMove();
			BridgeStatus bridgeStatus = bridgeGame.move(moveInput);
			bridgeResult.crossOneBridge(bridgeStatus, moveInput);
			oneBridgeResult(bridgeResult, bridgeStatus);
		} while (bridgeGame.isClear() == GameStatus.PASS);
	}

	private String requestMove() {
		outputView.printRequestMove();

		return inputView.readMoving();
	}

	private void oneBridgeResult(BridgeResult bridgeResult, BridgeStatus bridgeStatus) {
		outputView.printMap(bridgeResult);
		bridgeGame.checkClear(bridgeResult);
		checkBridgeStatus(bridgeStatus, bridgeResult);
	}

	private void checkBridgeStatus(BridgeStatus bridgeStatus, BridgeResult bridgeResult) {
		if (bridgeStatus == BridgeStatus.FAIL) {
			outputView.printRequestRetry();
			askContinue(inputView.readGameCommand(), bridgeResult);
		}
	}

	private void askContinue(String input, BridgeResult bridgeResult) {
		if (bridgeGame.retry(input)) {
			crossingBridge();

			return;
		}

		bridgeGame.end(bridgeResult);
	}
}
