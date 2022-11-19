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
		progressMap = new ProgressMap(bridgeSize);
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

	private void startBridgeGame(BridgeGame bridgeGame) {
		boolean playGame = true;
		while (playGame && !bridgeGame.isClear(progressMap)) {
			crossBridge(bridgeGame);
			if (progressMap.isMoveFailed()) {
				playGame = failBridgeMove(bridgeGame);
			}
		}
	}

	private boolean failBridgeMove(BridgeGame bridgeGame) {
		if (askRetry()) {
			bridgeGame.retry();
			return true;
		}
		return false;
	}

	private void crossBridge(BridgeGame bridgeGame) {
		progressMap = bridgeGameService.initGameMap(bridgeGame.getBridgeSize());
		while (!progressMap.isMoveFailed() && !bridgeGame.isClear(progressMap)) {
			moveBridgeOneTime(bridgeGame);
			outputView.printMap(progressMap.getProgressMap());
		}
	}
	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = receiveMoveCommand();
		bridgeGameService.moveBridge(moving, bridgeGame, progressMap);
	}
}
