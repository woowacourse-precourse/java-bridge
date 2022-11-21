package bridge.controller;

import static bridge.view.InputView.RETRY;

import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;
import bridge.service.BridgeGame;
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
		bridgeGame = new BridgeGame(inputView.readBridgeSize());
	}

	private void crossingBridge() {
		BridgeResult bridgeResult = new BridgeResult();

		do {
			String moveInput = requestMove();
			BridgeStatus bridgeStatus = bridgeGame.move(moveInput);
			bridgeResult.crossOneBridge(bridgeStatus, moveInput);
			oneBridgeResult(bridgeResult, bridgeStatus);
		} while (bridgeGame.checkEnd() == BridgeStatus.PASS);
	}

	private String requestMove() {
		outputView.printRequestMove();

		return inputView.readMoving();
	}

	private void oneBridgeResult(BridgeResult bridgeResult, BridgeStatus bridgeStatus) {
		outputView.printMap(bridgeResult);
		bridgeGame.checkClear(bridgeResult);
		checkRetry(bridgeStatus, bridgeResult);
	}

	private void checkRetry(BridgeStatus bridgeStatus, BridgeResult bridgeResult) {
		if (bridgeStatus == BridgeStatus.FAIL) {
			outputView.printRequestRetry();
			askContinue(inputView.readGameCommand(), bridgeResult);
		}
	}

	private void askContinue(String Input, BridgeResult bridgeResult) {
		if (Input.equals(RETRY)) {
			bridgeGame.retry();
			crossingBridge();

			return;
		}
		bridgeGame.end(bridgeResult);
	}
}
