package bridge;

import java.util.List;

public class View{

	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	public void start() {
		outputView.printStart();
	}

	public int readBridgeSize() {
		int bridgeSize;
		try {
			bridgeSize = inputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			bridgeSize = readBridgeSize();
		}
		return bridgeSize;
	}

	public String readMoving() {
		String moving;
		try {
			moving = inputView.readMoving();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			moving = readMoving();
		}
		return moving;
	}

	public String readRetry() {
		return inputView.readGameCommand();
	}

	public void printMap(List<String>result, List<String> bridge) {
		outputView.printMap(result, bridge);
	}

	public void printResult(List<String> result, List<String> bridge, int count) {
		outputView.printResult(result, bridge, count);
	}

}
