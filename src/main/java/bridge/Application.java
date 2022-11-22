package bridge;

import bridge.utils.Controller.GameController;

public class Application {
	private static GameController gameController = new GameController();

	public static void main(String[] args) {
		gameController.start();
	}
}
