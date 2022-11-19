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

	public BridgeGameController() {
		this.bridgeGameService = new BridgeGameService();
	}

	public void start() {
		inputView.printIntroMessage();
		int bridgeSize = receiveBridgeSize();
		List<String> bridge = bridgeGameService.initBridge(bridgeSize);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		ProgressMap currentMap = startBridgeGame(bridgeGame);
		outputView.printResult(currentMap.getProgressMap() , bridgeGame);
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

	private ProgressMap startBridgeGame(BridgeGame bridgeGame) {
		boolean playGame = true;
		ProgressMap currentMap = null;
		while (playGame) {
			bridgeGame.retry();
			currentMap = makeResultMap(bridgeGame);
			if (currentMap.whatMapSize() == bridgeGame.getBridgeSize()) {
				break;
			}
			playGame = askRetry();
		}
		return currentMap;
	}

	private ProgressMap makeResultMap(BridgeGame bridgeGame) {
		ProgressMap moveMap = bridgeGameService.initGameMap();
		while (!moveMap.isClearFailed() && moveMap.whatMapSize() < bridgeGame.getBridgeSize()) {
			moveBridgeOneTime(bridgeGame, moveMap);
		}
		return moveMap;
	}
	private void moveBridgeOneTime(BridgeGame bridgeGame, ProgressMap currentMap) {
		String moving = receiveMoveCommand();
		bridgeGameService.moveBridge(moving, bridgeGame, currentMap);
		outputView.printMap(currentMap.getProgressMap());
	}
}
