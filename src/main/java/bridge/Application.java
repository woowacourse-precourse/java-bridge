package bridge;

import bridge.config.AppConfig;
import bridge.controller.GameController;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		GameController gameController = new AppConfig().config();
		gameController.startApplication();
	}
}
