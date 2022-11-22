package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGameInitialization;

public class Application {
	public static void main(String[] args) {
		BridgeGameInitialization bridgeGameInitialization = new BridgeGameInitialization();
		BridgeGameController bridgeGameController = new BridgeGameController(bridgeGameInitialization);

		bridgeGameController.playBridgeGame();
	}
}
