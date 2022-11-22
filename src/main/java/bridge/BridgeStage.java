package bridge;

import java.util.List;

public class BridgeStage {

	private List<String> bridge;
	private InputView inputView;
	private OutputView outputView;

	public BridgeStage() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void makeBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		outputView.printInit();
		int size = inputView.readBridgeSize();
		bridge = bridgeMaker.makeBridge(size);
	}
}
