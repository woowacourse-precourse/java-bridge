package bridge.controller;

import static bridge.domain.State.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.ProgressMap;
import bridge.view.OutputView;

public class BridgeGameController {
	private final InputController inputController = new InputController();
	private final OutputView outputView = new OutputView();

	public void start() {
		outputView.printIntroMessage();
		BridgeGame bridgeGame = settingBridgeGame();
		startBridgeGame(bridgeGame);
	}

	private BridgeGame settingBridgeGame() {
		int bridgeSize = inputController.receiveBridgeSize();
		return initBridgeGame(bridgeSize);
	}

	private BridgeGame initBridgeGame(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
		return new BridgeGame(bridge);
	}

	private void startBridgeGame(BridgeGame bridgeGame) {
		ProgressMap progressMap = new ProgressMap();
		while (bridgeGame.getState() == PLAY) {
			moveBridgeOneTime(bridgeGame, progressMap);
			if (bridgeGame.getState() == MOVE_FAILED) {
				progressMap = bridgeGame.retry(inputController.askRetry(), progressMap);
			}
		}
		outputView.printResult(progressMap, bridgeGame);
	}

	private void moveBridgeOneTime(BridgeGame bridgeGame, ProgressMap progressMap) {
		String moving = inputController.receiveMoveCommand();
		bridgeGame.move(moving, progressMap);
		outputView.printMap(progressMap);
	}
}
