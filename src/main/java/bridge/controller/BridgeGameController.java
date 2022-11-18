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
		List<String> bridge = receiveBridgeSize();
		BridgeGame bridgeGame = new BridgeGame(bridge);
		List<List<String>> currentMap = makeResultMap(bridgeGame);
	}

	private List<String> receiveBridgeSize() {
		try {
			int size = inputView.readBridgeSize();
			return bridgeGameService.initBridge(size);
		}  catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveBridgeSize();
		}
	}

	private List<List<String>> makeResultMap(BridgeGame bridgeGame) {
		List<List<String>> moveMap = bridgeGameService.initGameMap();
		while (!failedClear(moveMap) && moveMap.get(0).size() < 3) {
			crossBridge(bridgeGame, moveMap);
		}
		return moveMap;
	}

	private void crossBridge(BridgeGame bridgeGame,List<List<String>> currentMap) {
		try {
			String moving = inputView.readMoving();
			bridgeGameService.moveBridge(moving, bridgeGame, currentMap);
			outputView.printMap(currentMap);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
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
}
