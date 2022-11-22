package bridge;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		int bridgeSize = inputView.readBridgeSize();

		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

		BridgeGame bridgeGame = new BridgeGame(bridge);

		bridgeGame.move();
	}
}
