package bridge;

import bridge.controller.BridgeController;

public class Application {

	public static void main(String[] args) {
		BridgeController bridgeController = new BridgeController();
		try {
			bridgeController.run();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
