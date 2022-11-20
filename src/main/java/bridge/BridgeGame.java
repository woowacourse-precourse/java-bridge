package bridge;

public class BridgeGame {

	private InputController input;
	private Bridge bridge;
	private OutputView output;
	private int gameTry = 1;

	public void init() {
		BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		input = new InputController();
		bridge = new Bridge(bridgeMaker.makeBridge(input.requestBridgeSize()));
		output = new OutputView();
	}

	public void play() {
		init();
		boolean status = true;
		int round = 0;
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
			round += checkO(movement);
			status = retry(status);
		}
		return status;
	}

	public int checkO(String movement) {
		if (movement.equals(" O ")) {
			return 1;
		}
		return 0;
	}

	public boolean checkX(String movement) {
		return movement.equals(" O ");
	}

	public String checkMovable(int round, String userInput) {
		if (userInput.equals("U")) {
			return bridge.getUpperBridge().get(round);
		}
		return bridge.getLowerBridge().get(round);
	}

	public boolean retry(boolean status) {
		if (status) {
			return true;
		}
		gameTry++;
		return input.requestRetry().equals("R");
	}
}
