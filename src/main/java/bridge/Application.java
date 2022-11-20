package bridge;

import controller.BridgeGameController;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		try {
			BridgeGameController bridgeGameController = new BridgeGameController();
			bridgeGameController.gameProgress();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}