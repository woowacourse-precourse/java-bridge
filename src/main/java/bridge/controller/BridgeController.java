package bridge.controller;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeResult;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.utils.Notice;
import bridge.view.OutputView;

public class BridgeController {
	final int MIN_SIZE = 3;
	final int MAX_SIZE  = 20;
	final String RETRY = "R";
	final String END = "Q";

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
		BridgeResult result = new BridgeResult("", 0);

		return saveGameResult(result, bridge);
	}

	private BridgeResult saveGameResult(BridgeResult result, List<String> bridge) {
		do {
			String movingResult = new MovingController().crossBridge(bridge);
			result = new BridgeResult(movingResult, result.getCount() + 1);

			if (result.getIsClear()) {
				break;
			}
		} while (new BridgeGame().retry(choiceEndOrNot()));

		return result;
	}

	/*
		view 관련 클래스
	 */
	private void printResult(int count, String result) {

		new OutputView().printResult(result, count);
	}

	private int choiceBridgeSize() {
		printNotice(Notice.CHOICE_SIZE.getMessage());

		try {
			return checkBrideSizeRange(Integer.parseInt(new InputView().readBridgeSize()));
		} catch (IllegalArgumentException e) {
			printNotice(Notice.ERROR.getMessage() + Notice.EXCEPTION_SIZE.getMessage());
		}
		return choiceBridgeSize();
	}

	private String choiceEndOrNot() {
		printNotice(Notice.RETRY.getMessage());

		try {
			return checkGameCommand(new InputView().readGameCommand());
		} catch (IllegalArgumentException e) {
			printNotice(Notice.ERROR.getMessage() + Notice.EXCEPTION_GAME_COMMAND.getMessage());
		}
		return choiceEndOrNot();
	}

	public int checkBrideSizeRange(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException();
		}

		return size;
	}

	public String checkGameCommand(String gameCommand) {
		if (!(gameCommand.equals(RETRY) || gameCommand.equals(END))) {
			throw new IllegalArgumentException();
		}

		return gameCommand;
	}

}
