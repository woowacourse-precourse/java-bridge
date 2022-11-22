package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGameInitialization;
import bridge.vo.UserPlayer;

public class Application {
	public static void main(String[] args) {
		BridgeGameInitialization bridgeGameInitialization = new BridgeGameInitialization();
		UserPlayer userPlayer = new UserPlayer();
		BridgeGameController bridgeGameController = new BridgeGameController(bridgeGameInitialization, userPlayer);

		bridgeGameController.playBridgeGame();
	}
}
