package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private BridgeGame bridgeGame;
	public void run() {
		gameStart();
	}

	private void gameStart() {
		outputView.printStart();
		outputView.printRequestBridgeSize();
		bridgeGame = new BridgeGame(inputView.readBridgeSize());
	}
}
