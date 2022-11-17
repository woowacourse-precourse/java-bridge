package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.validation.Validation;
import bridge.view.OutputView;

public class Controller {
	private static final int MOVING_DIRECTION_LENGTH = 1;
	private static final int INIT_MOVE_COUNT = 0;
	private static OutputView outputView = new OutputView();
	private static BridgeGame bridgeGame = new BridgeGame();
	private static int tryCount = 0;
	private static int moveCount = 0;

	public void bridgeGame(BridgeMaker bridgeMaker) {
		bridgeGame.createBridge(bridgeMaker);
		initTryCount();
		startBridgeGame();
		outputView.printResult(moveCount, tryCount);
	}

	private void initTryCount() {
		tryCount = 0;
	}

	private void startBridgeGame() {
		boolean isReStart = false;

		do {
			bridgeGame.initMap();
			moveCount = crossBridge(outputView, bridgeGame, INIT_MOVE_COUNT);
			isReStart = checkReStart(isReStart);

			tryCount++;
		} while (isReStart);
	}

	private static boolean checkReStart(boolean isReStart) {
		if (bridgeGame.isClearCrossBridge()) {
			isReStart = false;
		}
		if (bridgeGame.isFailCrossBridge()) {
			isReStart = bridgeGame.retry();
		}

		return isReStart;
	}

	private static int crossBridge(OutputView outputView, BridgeGame bridgeGame, int moveCount) {
		do {
			String movingDirection = Validation.validateMoving(MOVING_DIRECTION_LENGTH);
			bridgeGame.move(moveCount++, movingDirection);
			outputView.printMap(moveCount);

		} while (!bridgeGame.isClearCrossBridge() && !bridgeGame.isFailCrossBridge());

		return moveCount;
	}
}
