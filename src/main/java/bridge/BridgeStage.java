package bridge;

import java.util.List;

public class BridgeStage {

	private List<String> bridge;
	private int position;
	private InputView inputView;
	private OutputView outputView;

	public BridgeStage() {
		inputView = new InputView();
		outputView = new OutputView();
		position = 0;
	}

	public void makeBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		outputView.printInit();
		int size = inputView.readBridgeSize();
		bridge = bridgeMaker.makeBridge(size);
	}

	public boolean move() {
		outputView.printMove();
		String order = inputView.readGameCommand();
		return process(order);
	}

	private boolean process(String order) {
		if (!bridge.get(position).equals(order)) {
			return false;
		}
		position += 1;
		return true;
	}
}
