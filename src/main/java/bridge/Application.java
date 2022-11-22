package bridge;

import bridge.domain.BridgeGame;

public class Application {
	private static BridgeGame bridgeGame;

	public static void main(String[] args) {
		bridgeGame = new BridgeGame();
		bridgeGame.start();
	}
}
