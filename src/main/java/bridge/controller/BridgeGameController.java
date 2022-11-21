package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
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
		return new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
	}

	private void startBridgeGame(BridgeGame bridgeGame) {
		boolean startGame = true;
		while (startGame && bridgeGame.isNotFinish(progressMap)) {
			crossBridge(bridgeGame);
			if (progressMap.isMoveFailed()) {
				startGame = bridgeGame.retry(inputController.askRetry());
			}
		}
	}

	private void crossBridge(BridgeGame bridgeGame) {
		progressMap = initGameMap();
		while (!progressMap.isMoveFailed() && bridgeGame.isNotFinish(progressMap)) {
			moveBridgeOneTime(bridgeGame);
			OutputView.printMap(progressMap);
		}
	}

	private ProgressMap initGameMap() {
		return new ProgressMap();
	}

	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = inputController.receiveMoveCommand();
		bridgeGame.move(moving, progressMap);
	}
}
