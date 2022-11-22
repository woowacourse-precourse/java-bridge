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
	private static final BridgeMakeController bridgeMakeController =
		new BridgeMakeController(bridgeGame, inputView);
	private static final BridgeMoveController bridgeMoveController =
		new BridgeMoveController(bridgeGame, inputView, outputView);
	private static final BridgeCommandController bridgeCommandController =
		new BridgeCommandController(bridgeGame, inputView, outputView);

	public void run() {
		startView.printGameStartMessage();
		bridgeMakeController.makeBridge();
		bridgeMoveController.processBridgeMove(bridgeCommandController);
		outputView.printResultMessage();
	}

	public void clearRunning() {
		outputView.clearOutputView();
		bridgeGame.clearGameData();
	}
}
