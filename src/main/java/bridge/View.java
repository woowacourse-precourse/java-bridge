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
		String retry;
		try {
			retry = inputView.readGameCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			retry = readRetry();
		}
		return retry;
	}

	public void printMap(List<String>result, List<String> bridge) {
		outputView.printMap(result, bridge);
	}

	public void printResult(List<String> result, List<String> bridge, int count) {
		outputView.printResult(result, bridge, count);
	}

}
