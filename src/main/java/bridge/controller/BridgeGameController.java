package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.ProgressMap;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final BridgeGameService bridgeGameService;
	private ProgressMap progressMap;

	public BridgeGameController() {
		this.bridgeGameService = new BridgeGameService();
	}

	public void start() {
		InputView.printIntroMessage();
		BridgeGame bridgeGame = settingBridgeGame();
		startBridgeGame(bridgeGame);
		OutputView.printResult(progressMap.getProgressMap(), bridgeGame);
	}

	private BridgeGame settingBridgeGame() {
		int bridgeSize = receiveBridgeSize();
		progressMap = new ProgressMap();
		return bridgeGameService.initBridgeGame(bridgeSize);
	}

	private int receiveBridgeSize() {
		try {
			int size = InputView.readBridgeSize();
			return bridgeGameService.checkBridgeSize(size);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveBridgeSize();
		}
	}

	private void startBridgeGame(BridgeGame bridgeGame) {
		boolean startGame = true;
		while (startGame && bridgeGame.isNotFinish(progressMap)) {
			crossBridge(bridgeGame);
			if (progressMap.isMoveFailed()) {
				startGame = failBridgeMove(bridgeGame);
			}
		}
	}

	private void crossBridge(BridgeGame bridgeGame) {
		progressMap = bridgeGameService.initGameMap();
		while (!progressMap.isMoveFailed() && bridgeGame.isNotFinish(progressMap)) {
			moveBridgeOneTime(bridgeGame);
			OutputView.printMap(progressMap.getProgressMap());
		}
	}

	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = receiveMoveCommand();
		bridgeGame.move(moving, progressMap);
	}

	private String receiveMoveCommand() {
		try {
			String moving = InputView.readMoving();
			return bridgeGameService.checkMoveCommand(moving);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveMoveCommand();
		}
	}

	private boolean askRetry() {
		try {
			String retryInput = InputView.readGameCommand();
			return bridgeGameService.retryOrEnd(retryInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askRetry();
		}
	}

	private boolean failBridgeMove(BridgeGame bridgeGame) {
		if (askRetry()) {
			bridgeGame.retry();
			return true;
		}
		return false;
	}
}
