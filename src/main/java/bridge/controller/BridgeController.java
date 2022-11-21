package bridge.controller;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeResult;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.utils.Notice;
import bridge.view.OutputView;

public class BridgeController {

	public void printNotice(String message) {
		new OutputView().printMap(message);
	}

	public void start() {
		printNotice(Notice.START.getMessage());
		int bridgeSize = choiceBridgeSize();

		BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

		BridgeResult result = getGameResult(maker.makeBridge(bridgeSize));
		printResult(result.getCount(), result.getResult());
	}

	private BridgeResult getGameResult(List<String> bridge) {
		BridgeResult result = initializationBridgeResult("", 0);

		return saveGameResult(result, bridge);
	}

	private BridgeResult saveGameResult(BridgeResult result, List<String> bridge) {
		do {
			String movingResult = new RunController().getMovingResult(bridge);
			result = initializationBridgeResult(movingResult, result.getCount() + 1);

			if (result.isClear()) {
				break;
			}
		} while (new BridgeGame().retry(choiceEndOrNot()));

		return result;
	}

	private BridgeResult initializationBridgeResult(String result, int count) {
		return new BridgeResult(result, count, new RunController().isClearGame(result));
	}

	private void printResult(int count, String result) {

		new OutputView().printResult(result, count);
	}

	private int choiceBridgeSize() {
		printNotice(Notice.CHOICE_SIZE.getMessage());

		return new InputView().readBridgeSize();
	}

	private String choiceEndOrNot() {
		printNotice(Notice.RETRY.getMessage());

		return new InputView().readGameCommand();
	}

}
