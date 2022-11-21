package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.StartView;

public class BridgeGameController {
	private static final StartView startView = new StartView();
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final BridgeGame bridgeGame = new BridgeGame();

	public void run() {
		BridgeMakeController bridgeMakeController = new BridgeMakeController(bridgeGame, inputView);
		BridgeMoveController bridgeMoveController =
			new BridgeMoveController(bridgeGame, inputView, outputView);

		startView.printGameStartMessage();
		bridgeMakeController.makeBridge();
		bridgeMoveController.processBridgeMove();
		outputView.printResultMessage();
	}
}
