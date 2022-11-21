package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.Bridge;
import bridge.BridgeResult;
import bridge.service.BridgeGame;
import bridge.service.MovingService;

public class GameRunController {

	public String getMovingResult(List<String> bridge) {
		List<Integer> top = new ArrayList<>();
		List<Integer> bottom = new ArrayList<>();

		String movingResult = crossBridge(bridge, top, bottom);

		return movingResult;
	}

	public String crossBridge(List<String> bridge, List<Integer> top, List<Integer> bottom) {
		String movingResult = "";

		for (String shape : bridge) {
			movingResult = compareMovingAndBridge(shape, top, bottom);

			if (movingResult.contains(Bridge.WRONG.getResult())) {
				break;
			}
		}
		return movingResult;
	}

	public String compareMovingAndBridge(String shape, List<Integer> top, List<Integer> bottom) {
		String initialMoving = new BridgeController().choiceMoving();
		String changedMoving = new MovingService().changeMoving(shape, initialMoving);
		String movingResult = new MovingService().saveUserMoving(new BridgeGame().move(changedMoving), top, bottom);

		new BridgeController().noticePrint(movingResult);

		return movingResult;
	}


}
