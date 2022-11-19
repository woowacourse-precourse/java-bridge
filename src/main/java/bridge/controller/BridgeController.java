package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import bridge.repository.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

public class BridgeController {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	private static final BridgeGame bridgeGame = new BridgeGame();

	public static void run() {
		List<String> bridge = initBridge();
		boolean retry = true;
		int gameCount = 0;
		List<String> currentBridgeState = null;
		while (retry && gameCount++ >=0) {
			currentBridgeState = getCurrentBridgeState(bridge);
			retry = isRetry(bridge, currentBridgeState);
		}
		gameFinish(bridge, gameCount, currentBridgeState);
	}

	private static boolean isRetry(List<String> bridge, List<String> currentBridgeState) {
		boolean retry;
		retry = endOrNot(bridge, currentBridgeState);
		retry = isRetry(retry);
		return retry;
	}

	private static List<String> getCurrentBridgeState(List<String> bridge) {
		List<String> currentBridgeState;
		currentBridgeState = new ArrayList<>();
		gameStart(bridge, currentBridgeState);
		return currentBridgeState;
	}

	private static List<String> initBridge() {
		Message.printMessage(Message.START_GAME);
		List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
		return bridge;
	}

	private static boolean isRetry(boolean retry) {
		if (retry && !bridgeGame.retry(inputView.readGameCommand())) {
			retry = false;
		}
		return retry;
	}

	private static boolean endOrNot(List<String> bridge, List<String> currentBridgeState) {
		if (bridgeGame.isAnswerBridge(bridge, currentBridgeState)) {
			return false;
		}
		return true;
	}

	private static void gameStart(List<String> bridge, List<String> currentBridgeState) {
		while (currentBridgeState.size() < bridge.size()) {
			bridgeGame.move(currentBridgeState, inputView.readMoving());
			if (!outputView.printMap(bridge, currentBridgeState)) {
				break;
			}
		}
	}

	private static void gameFinish(List<String> bridge, int gameCount, List<String> currentBridgeState) {
		Message.printMessage(Message.FINAL_GAME_RESULT);
		Message.printFinalMessage(outputView.printFinalMapResult(bridge, currentBridgeState), gameCount);
	}

}
