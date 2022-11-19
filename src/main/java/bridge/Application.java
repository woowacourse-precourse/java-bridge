package bridge;

import bridge.controller.BridgeController;

public class Application {

	public static void main(String[] args) {
		try {
			BridgeController.run();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
