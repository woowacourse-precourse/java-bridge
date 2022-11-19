package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
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
		List<List<String>> currentMap = startBridgeGame(bridgeGame);
		outputView.printResult(currentMap, bridgeGame);
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

	private List<List<String>> startBridgeGame(BridgeGame bridgeGame) {
		boolean playGame = true;
		List<List<String>> currentMap = new ArrayList<>();
		while (playGame) {
			bridgeGame.retry();
			currentMap = makeResultMap(bridgeGame);
			if (currentMap.get(0).size() == bridgeGame.getBridgeSize()) {
				return currentMap;
			}
			playGame = askRetry();
		}
		return currentMap;
	}

	private List<List<String>> makeResultMap(BridgeGame bridgeGame) {
		List<List<String>> moveMap = bridgeGameService.initGameMap();
		while (!failedClear(moveMap) && moveMap.get(0).size() < bridgeGame.getBridgeSize()) {
			crossBridge(bridgeGame, moveMap);
		}
		return moveMap;
	}

	private void crossBridge(BridgeGame bridgeGame, List<List<String>> currentMap) {
		try {
			String moving = inputView.readMoving();
			bridgeGameService.moveBridge(moving, bridgeGame, currentMap);
			outputView.printMap(currentMap);
		} catch (IllegalArgumentException e) {
			System.out.print(e.getMessage());
			crossBridge(bridgeGame, currentMap);
		}
	}

	private boolean failedClear(List<List<String>> currentMap) {
		List<String> upMap = currentMap.get(0);
		List<String> downMap = currentMap.get(1);
		return (checkInCorrect(upMap) || checkInCorrect(downMap));
	}

	private boolean checkInCorrect(List<String> map) {
		return map.stream().anyMatch(m -> m.contains("X"));
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
}
