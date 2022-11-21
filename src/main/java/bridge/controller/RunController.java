package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.service.MovingService;
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

	public String getMovingResult(List<String> bridge) {
		List<Integer> top = new ArrayList<>();
		List<Integer> bottom = new ArrayList<>();

		String movingResult = crossBridge(bridge, top, bottom);

		return movingResult;
	}

	private String crossBridge(List<String> bridge, List<Integer> top, List<Integer> bottom) {
		String movingResult = "";

		for (String shape : bridge) {
			movingResult = compareMovingAndBridge(shape, top, bottom);

			if (movingResult.contains(Bridge.WRONG.getResult())) {
				break;
			}
		}
		return movingResult;
	}

	private String compareMovingAndBridge(String shape, List<Integer> top, List<Integer> bottom) {
		String initialMoving = choiceMoving();
		String changedMoving = new MovingService().changeMoving(shape, initialMoving);
		String movingResult = new MovingService().saveUserMoving(new BridgeGame().move(changedMoving), top, bottom);

		new BridgeController().printNotice(movingResult);

		return movingResult;
	}

	private String choiceMoving() {
		new BridgeController().printNotice(Notice.CHOICE_MOVE.getMessage());

		return new InputView().readMoving();
	}

}
