package bridge.controller;

import bridge.Bridge;
import bridge.InputView;
import bridge.Notice;

public class RetryController {
	final String RETRY = "R";

	public boolean isNotFinish(String result) {
		boolean isClear = false;

		if (result.contains(Bridge.WRONG.getOrder())) {
			isClear = choiceEndOrNOT();
		}
		return isClear;
	}

	private boolean choiceEndOrNOT() {
		InputView input = new InputView();
		BridgeController controller = new BridgeController();

		controller.noticePrint(Notice.RETRY.getMessage());
		String gameCommand = input.readGameCommand();

		return chooseResult(gameCommand);
	}

	private boolean chooseResult(String command) {

		return command.equals(RETRY);
	}
}
