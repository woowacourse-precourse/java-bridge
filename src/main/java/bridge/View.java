package bridge;

import java.util.List;

public class View {

	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	public void start() {
		outputView.printStart();
	}

	public int readBridgeSize() {
		return inputView.readBridgeSize();
	}

	public String readMoving() {
		return inputView.readMoving();
	}

	public String readRetry() {
		return inputView.readGameCommand();
	}

	public void printMap(List<String>result, List<String> bridge) {
		outputView.printMap(result, bridge);
	}

}
