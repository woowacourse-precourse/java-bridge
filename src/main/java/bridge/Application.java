package bridge;

import bridge.ui.ErrorView;

public class Application {

	public static void main(String[] args) {
		BridgeGame bridgeGame = new BridgeGame();
		try {
			bridgeGame.init();
			bridgeGame.start();
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorView.errorMsg);
		}
	}
}
