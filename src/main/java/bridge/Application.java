package bridge;

import bridge.enums.Error;

public class Application {

	public static void main(String[] args) {
		try {
			BridgeGame bridgeGame = new BridgeGame();
			bridgeGame.play();
		} catch (IllegalArgumentException exception) {
			System.out.println(Error.HEAD.getValue() + exception.getMessage());
		}
	}
}
