package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.Bridge;
import bridge.domain.Challenger;
import bridge.service.BridgeGame;
import bridge.utils.Notice;
import bridge.view.InputView;

public class RunController {

	public boolean isClearGame(String result) {
		boolean isClear = true;

		if (result.contains(Bridge.WRONG.getResult())) {
			return false;
		}
		return isClear;
	}

	public String crossBridge(List<String> bridge) {
		Challenger challenger = new Challenger(new ArrayList<>(), new ArrayList<>());

		compare(bridge, challenger);

		return challenger.getResult();
	}

	private void compare(List<String> bridge, Challenger challenger) {
		for (String shape : bridge) {
			checkForCorrectMovements(shape, challenger);
			saveUserMoving(challenger);

			if (challenger.getResult().contains(Bridge.WRONG.getResult())) {
				break;
			}
		}
	}

	private void saveUserMoving(Challenger challenger) {
		challenger.setResult();

		new BridgeController().printNotice(challenger.getResult());
	}

	private void checkForCorrectMovements(String shape, Challenger challenger) {
		challenger.setMoving(shape, choiceMoving());
		challenger.setUserMoving(new BridgeGame().move(challenger.getMoving()));
	}

	private String choiceMoving() {
		new BridgeController().printNotice(Notice.CHOICE_MOVE.getMessage());

		try {
			return checkMoving(new InputView().readMoving());
		} catch (IllegalArgumentException e) {
			new BridgeController().printNotice(Notice.ERROR.getMessage());
		}
		return choiceMoving();
	}

	public String checkMoving(String move) {
		if (!(move.equals(Bridge.TOP.getOrder()) || move.equals(Bridge.BOTTOM.getOrder()))) {
			throw new IllegalArgumentException();
		}

		return move;
	}

}
