package bridge.controller;

import bridge.game.BridgeGame;
import bridge.BridgeMaker;
import bridge.validation.Validation;
import bridge.view.OutputView;

public class Controller {
	private static final int MOVING_DIRECTION_LENGTH = 1;
	private static final int INIT_MOVE_COUNT = 0;
	private static OutputView outputView = new OutputView();
	private static BridgeGame bridgeGame = new BridgeGame();
	private static int tryCount = 0;

	public static void bridgeGame(BridgeMaker bridgeMaker) {
		bridgeGame.createBridge(bridgeMaker);
		initTryCount();
		startBridgeGame();
		outputView.printResult(tryCount);
	}

	private static void initTryCount() {
		tryCount = 0;
	}

	private static void startBridgeGame() {
		boolean reStart = false;

		do {
			bridgeGame.initMap();
			crossBridge(INIT_MOVE_COUNT);
			reStart = isReStart(reStart);

			tryCount++;
		} while (reStart);
	}

	private static boolean isReStart(boolean isReStart) {
		if (bridgeGame.isClearCrossBridge()) {
			isReStart = false;
		}
		if (bridgeGame.isFailCrossBridge()) {
			isReStart = bridgeGame.retry();
		}

		return isReStart;
	}

	private static void crossBridge(int moveCount) {
		do {
			String movingDirection = Validation.validateMoving(MOVING_DIRECTION_LENGTH);
			bridgeGame.move(moveCount++, movingDirection);
			outputView.printMap();
		} while (!bridgeGame.isClearCrossBridge() && !bridgeGame.isFailCrossBridge());
	}
}
