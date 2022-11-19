package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.ProgressMap;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeGameService bridgeGameService;
	private ProgressMap progressMap;

	public BridgeGameController() {
		this.bridgeGameService = new BridgeGameService();
	}

	public void start() {
		inputView.printIntroMessage();
		BridgeGame bridgeGame = settingBridgeGame();
		startBridgeGame(bridgeGame);
		outputView.printResult(progressMap.getProgressMap(), bridgeGame);
	}

	private BridgeGame settingBridgeGame() {
		int bridgeSize = receiveBridgeSize();
		progressMap = new ProgressMap();
		return bridgeGameService.initBridgeGame(bridgeSize);
	}

	private int receiveBridgeSize() {
		try {
			int size = inputView.readBridgeSize();
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
			outputView.printMap(progressMap.getProgressMap());
		}
	}

	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = receiveMoveCommand();
		bridgeGameService.moveBridge(moving, bridgeGame, progressMap);
	}

	private String receiveMoveCommand() {
		try {
			String moving = inputView.readMoving();
			return bridgeGameService.checkMoveCommand(moving);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveMoveCommand();
		}
	}

	private boolean askRetry() {
		try {
			String retryInput = inputView.readGameCommand();
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
