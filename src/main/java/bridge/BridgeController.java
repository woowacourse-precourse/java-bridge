package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

	public void start() {
		noticePrint(Notice.START.getMessage());
		int bridgeSize = getBridgeSize();

		BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

		BridgeGame game = new BridgeGame();
		game.retry(maker.makeBridge(bridgeSize));
	}

	public String run(List<String> bridge) {
		List<Integer> bottomBridge = new ArrayList<>();
		List<Integer> topBridge = new ArrayList<>();

		compareBridge(bridge, topBridge, bottomBridge);

		return saveBridge(saveMap(topBridge), saveMap(bottomBridge));
	}

	public void stop(int count, String result) {
		OutputView output = new OutputView();

		output.printResult(result, count);
	}

	private int getBridgeSize() {
		InputView input = new InputView();

		noticePrint(Notice.CHOICE_SIZE.getMessage());

		return input.readBridgeSize();
	}

	private void noticePrint(String message) {
		OutputView output = new OutputView();

		output.printMap(message);
	}


	private String saveBridge(String topBridge, String bottomBridge) {
		return topBridge + "\n" + bottomBridge;
	}

	private void compareBridge(List<String> bridge, List<Integer> topBridge, List<Integer> bottomBridge) {
		for (String s : bridge) {
			List<Integer> userMove = new ArrayList<>();

			boolean isWrong = checkUserMoving(s, userMove);
			notYetName(userMove, topBridge, bottomBridge);

			if (isWrong) {
				break;
			}
		}
	}

	private void saveBridge(List<Integer> userMove, List<Integer> topBridge, List<Integer> bottomBridge) {
		topBridge.add(userMove.get(0));
		bottomBridge.add(userMove.get(1));
	}

	public static String saveMap(List<Integer> bridge) {
		StringBuilder map = new StringBuilder("[ ");

		judgement(map, bridge);
		map.append(" ]");

		return map.toString();
	}

	private static void judgement(StringBuilder map, List<Integer> bridge) {
		for (int i = 0; i < bridge.size(); i++) {
			map.append(Bridge.findOrder(bridge.get(i)).getResult());

			if (i < bridge.size() - 1) {
				map.append(" | ");
			}
		}
	}

	private boolean checkUserMoving(String s, List<Integer> userMove) {
		String moving = moveUser();
		boolean isWrong = isWrongMove(s, moving);

		BridgeGame game = new BridgeGame();
		game.move(userMove, moving, isWrong);

		return isWrong;
	}

	private void notYetName(List<Integer> userMove, List<Integer> top, List<Integer> bottom) {
		saveBridge(userMove, top, bottom);

		requestPrintMap(saveMap(top), saveMap(bottom));
	}

	public String moveUser() {
		InputView input = new InputView();

		noticePrint(Notice.CHOICE_MOVE.getMessage());

		return input.readMoving();
	}

	private boolean isWrongMove(String shape, String moving) {
		boolean isWrong = false;

		if (isNotEqual(shape, moving)) {
			return true;
		}

		return isWrong;
	}

	private static boolean isNotEqual(String bridge, String moving) {
		return !bridge.equals(moving);
	}

	private static void requestPrintMap(String up, String down) {
		OutputView output = new OutputView();

		output.printMap(up);
		output.printMap(down);
	}

	public boolean isNotFinish(String result) {
		boolean isClear = true;
		InputView input = new InputView();

		if (result.contains("X")) {
			noticePrint(Notice.RETRY.getMessage());
			String gameCommand = input.readGameCommand();

			if (gameCommand.equals("R")) {
				isClear = false;
			}
		}
		return isClear;
	}

	public String setWrongMoving(String moving) {
		String move = "F";

		if (moving.equals(Bridge.UP.getOrder())) {
			move = "W";
		}

		return move;
	}

}
