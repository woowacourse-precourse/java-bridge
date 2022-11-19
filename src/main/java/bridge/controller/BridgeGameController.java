package bridge.controller;

import java.util.ArrayList;
import java.util.List;

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
		int bridgeSize = receiveBridgeSize();
		List<String> bridge = bridgeGameService.initBridge(bridgeSize);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		startBridgeGame(bridgeGame);
		outputView.printResult(progressMap.getProgressMap() , bridgeGame);
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
			System.out.print(e.getMessage());
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
		while (playGame) {
			bridgeGame.retry();
			crossBridge(bridgeGame);
			if (progressMap.isClear()) {
				break;
			}
			playGame = askRetry();
		}
	}

	private void crossBridge(BridgeGame bridgeGame) {
		progressMap = bridgeGameService.initGameMap(bridgeGame.getBridgeSize());
		while (!progressMap.isMoveFail() && !progressMap.isClear()) {
			moveBridgeOneTime(bridgeGame);
			outputView.printMap(progressMap.getProgressMap());
		}
	}
	private void moveBridgeOneTime(BridgeGame bridgeGame) {
		String moving = receiveMoveCommand();
		bridgeGameService.moveBridge(moving, bridgeGame, progressMap);
	}
}
