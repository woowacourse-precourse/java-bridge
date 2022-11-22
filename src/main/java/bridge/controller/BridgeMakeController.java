package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;

public class BridgeMakeController {
	private final BridgeGame bridgeGame;
	private final InputView inputView;

	public BridgeMakeController(BridgeGame bridgeGame, InputView inputView) {
		this.bridgeGame = bridgeGame;
		this.inputView = inputView;
	}

	public void makeBridge() {
		boolean isError;

		do {
			isError = isSizeInputRight();
		} while (isError);
	}

	private boolean isSizeInputRight() {
		try {
			bridgeGame.startMakingBridge(inputView.readBridgeSize());
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}
}
