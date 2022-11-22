package bridge;

import java.util.List;

public class BridgeStage {

	private List<String> bridge;
	private int position;
	private int numTry;
	private boolean currentStatus;
	private InputView inputView;
	private OutputView outputView;

	public BridgeStage() {
		inputView = new InputView();
		outputView = new OutputView();
		position = 0;
		numTry = 1;
	}

	public void makeBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		outputView.printInit();
		int size = inputView.readBridgeSize();
		bridge = bridgeMaker.makeBridge(size);
	}

	public boolean move() {
		outputView.printMove();
		String order = inputView.readMoving();
		return process(order);
	}

	private boolean process(String order) {
		if (!bridge.get(position).equals(order)) {
			wrongMove();
			return false;
		}
		correctMove();
		if (position >= bridge.size()) {
			return false;
		}
		return true;
	}

	private void wrongMove() {
		currentStatus = false;
		outputView.printMap(bridge, position, Constants.WRONG);
		position = 0;
	}

	private void correctMove() {
		currentStatus = true;
		outputView.printMap(bridge, position, Constants.CORRECT);
		position += 1;
	}

	public boolean finish() {
		if (position >= bridge.size()) {
			outputView.printResult();
			outputView.printStatistic(currentStatus, numTry);
			return true;
		}
		return false;
	}

	public boolean retry() {
		outputView.printRetry();
		String order = inputView.readGameCommand();
		if (Control.RESTART.getControlOrder().equals(order)) {
			numTry += 1;
			return true;
		}
		outputView.printResult();
		return false;
	}
}
