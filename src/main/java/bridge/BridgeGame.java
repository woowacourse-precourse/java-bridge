package bridge;

import bridge.enums.Command;
import bridge.enums.Map;
import bridge.enums.Numeric;

public class BridgeGame {

	private InputController input;
	private Bridge bridge;
	private OutputController output;
	private int gameTry = Numeric.FIRST_TRY.getValue();

	public void init() {
		BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		input = new InputController();
		bridge = new Bridge(bridgeMaker.makeBridge(input.requestBridgeSize()));
		output = new OutputController();
	}

	public void play() {
		init();
		boolean status = true;
		int round = Numeric.INITIALIZE.getValue();
		output.printStart();
		status = move(round, status);
		output.printResult(status, gameTry);
	}

	public boolean move(int round, boolean status) {
		while (round < bridge.getSize() && status) {
			String userInput = input.requestMove();
			String movement = checkMovable(round, userInput);
			status = checkX(movement);
			output.printMap(round, bridge, userInput);
			round = checkO(round, movement, status);
			status = retry(status);
		}
		return status;
	}

	public int checkO(int round, String movement, boolean status) {
		if (!status) {
			return Numeric.INITIALIZE.getValue();
		}
		if (movement.equals(Map.SAFE.getValue())) {
			return round + Numeric.COUNT.getValue();
		}
		return round + Numeric.NON_COUNT.getValue();
	}

	public boolean checkX(String movement) {
		return movement.equals(Map.SAFE.getValue());
	}

	public String checkMovable(int round, String userInput) {
		if (userInput.equals(Command.UP.getValue())) {
			return bridge.getUpperBridge().get(round);
		}
		return bridge.getLowerBridge().get(round);
	}

	public boolean retry(boolean status) {
		if (status) {
			return true;
		}
		gameTry++;
		return input.requestRetry().equals(Command.RESTART.getValue());
	}
}
