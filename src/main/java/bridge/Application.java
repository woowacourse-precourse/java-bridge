package bridge;

import bridge.controller.Controller;

public class Application {

	public static void main(String[] args) {
		Controller.bridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
	}
}
