package bridge.controller;

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
 		} catch (IllegalArgumentException e) {
			Logger.error(e.getMessage());
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
			outputView.printRequestMove();
			String moveInput = inputView.readMoving();
			BridgeStatus bridgeStatus = bridgeGame.move(moveInput);
			bridgeResult.crossBridge(bridgeStatus, moveInput);
			outputView.printMap(bridgeResult);
			checkRetry(bridgeStatus);
		} while (bridgeGame.checkEnd() == BridgeStatus.PASS);
	}

	private void checkRetry(BridgeStatus bridgeStatus) {
		if (bridgeStatus == BridgeStatus.FAIL) {
			outputView.printRequestRetry();
			askContinue(inputView.readGameCommand());
		}
	}

	private void askContinue(String Input) {
		if (Input.equals("R")) {
			bridgeGame.retry();
			crossingBridge();
		}
		bridgeGame.end();
	}
}
