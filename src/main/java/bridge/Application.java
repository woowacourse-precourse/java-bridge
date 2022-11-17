package bridge;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		InputView inputView = new InputView();
		int bridgeSize = inputView.readBridgeSize();
		String upDown = inputView.readMoving();

		// BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		// List<String> bridge = bridgeMaker.makeBridge(bridgeSize);



	}
}
