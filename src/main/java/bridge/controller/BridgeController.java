package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.Notice;
import bridge.OutputView;
import bridge.service.MovingService;

public class BridgeController {

	public void start() {
		noticePrint(Notice.START.getMessage());
		int bridgeSize = getBridgeSize();

		BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

		run(maker.makeBridge(bridgeSize));
	}

	public void run(List<String> bridge) {
		BridgeGame game = new BridgeGame();
		String result;
		int count = 0;

		do {
			result = getResult(bridge);
			count++;
		} while (game.retry(result));

		stop(count, result);
	}

	public void stop(int count, String result) {
		OutputView output = new OutputView();

		output.printResult(result, count);
	}

	private String compareUserMovingAndBridge(List<String> bridge, List<Integer> topBridge, List<Integer> bottomBridge) {
		String userMoving = "";

		for (String shape : bridge) {
			userMoving = crossBridge(shape, topBridge, bottomBridge);

			if (userMoving.contains(Bridge.WRONG.getResult())) {
				break;
			}
		}
		return userMoving;
	}

	private String crossBridge(String shape, List<Integer> top, List<Integer> bottom) {
		MovingService movementManager = new MovingService();
		BridgeGame game = new BridgeGame();

		List<Integer> userMoving = game.move(movementManager.changeMoving(shape, getUserMoving()));
		String userMove = movementManager.saveUserMoving(userMoving, top, bottom);

		noticePrint(userMove);

		return userMove;
	}

	private int getBridgeSize() {
		InputView input = new InputView();

		noticePrint(Notice.CHOICE_SIZE.getMessage());

		return input.readBridgeSize();
	}

	private String getUserMoving() {
		InputView input = new InputView();

		noticePrint(Notice.CHOICE_MOVE.getMessage());

		return input.readMoving();
	}

	private String getResult(List<String> bridge) {
		List<Integer> topBridge = new ArrayList<>();
		List<Integer> bottomBridge = new ArrayList<>();

		return compareUserMovingAndBridge(bridge, topBridge, bottomBridge);
	}

	void noticePrint(String message) {
		OutputView output = new OutputView();

		output.printMap(message);
	}

}
