package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final InputView inputView = new InputView();
	private final BridgeGameService bridgeGameService;

	public BridgeGameController() {
		this.bridgeGameService = new BridgeGameService();
	}

	public void start() {
		List<String> bridge = receiveBridgeSize();
		BridgeGame bridgeGame = new BridgeGame(bridge);
		List<List<String>> result = makeResult(bridgeGame);
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

	private List<List<String>> makeResult(BridgeGame bridgeGame) {
		List<List<String>> moveResult = bridgeGameService.initGameResult();
		while (!failedClear(moveResult) && moveResult.get(0).size() < 3) {
			crossBridge(bridgeGame, moveResult);
		}
		return moveResult;
	}

	private void crossBridge(BridgeGame bridgeGame,List<List<String>> result) {
		try {
			String moving = inputView.readMoving();
			bridgeGameService.moveBridge(moving, bridgeGame, result);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			crossBridge(bridgeGame, result);
		}
	}

	private boolean failedClear(List<List<String>> result) {
		return result.stream().anyMatch(board -> board.contains("X"));
	}
}
