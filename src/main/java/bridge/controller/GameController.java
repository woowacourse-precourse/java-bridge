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
			bridgeResult.crossBridge(bridgeGame.move(moveInput), moveInput);
			outputView.printMap(bridgeResult);
		} while (bridgeGame.checkEnd() == BridgeStatus.PASS);


	}
}
