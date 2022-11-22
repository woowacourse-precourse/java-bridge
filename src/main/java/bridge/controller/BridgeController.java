package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
	public void run() {
		printBridgeGameStart();
		BridgeGame bridgeGame = initializeBridgeGame();

	}

	private void printBridgeGameStart() {
		OutputView.printBridgeGameStart();
	}

	private BridgeGame initializeBridgeGame() {
		OutputView.printInputBridgeSize();
		int bridgeSize = InputView.readBridgeSize();

		return new BridgeGame(bridgeSize);
	}
}
