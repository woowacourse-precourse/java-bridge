package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.ProgressMap;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final InputController inputController = new InputController();
	private ProgressMap progressMap;

	public void start() {
		InputView.printIntroMessage();
		BridgeGame bridgeGame = settingBridgeGame();
		startBridgeGame(bridgeGame);
		OutputView.printResult(progressMap, bridgeGame);
	}

	private BridgeGame settingBridgeGame() {
		int bridgeSize = inputController.receiveBridgeSize();
		progressMap = new ProgressMap();
		return initBridgeGame(bridgeSize);
	}

	private BridgeGame initBridgeGame(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
		return new BridgeGame(bridge);
	}

	private void startBridgeGame(BridgeGame bridgeGame) {
		boolean startGame = true;
		while (startGame && bridgeGame.isNotFinish(progressMap)) {
			moveBridgeOneTime(bridgeGame);
			if (progressMap.isMoveFailed()) {
				startGame = isRestart(bridgeGame);
			}
		}
	}

	private boolean isRestart(BridgeGame bridgeGame) {
		if (inputController.askRetry()) {
			progressMap = bridgeGame.retry();
			return true;
		}
		return false;
	}

	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = inputController.receiveMoveCommand();
		bridgeGame.move(moving, progressMap);
		OutputView.printMap(progressMap);
	}
}
