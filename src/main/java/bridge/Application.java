package bridge;

import bridge.controller.BridgeController;
import bridge.view.OutputView;

public class Application {

	public static void main(String[] args) {
		BridgeController bridgeController = new BridgeController();
		try {
			bridgeController.run();
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
		}
	}
}
