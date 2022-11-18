package bridge;

import bridge.config.AppConfig;
import bridge.controller.BridgeGame;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		BridgeGame bridgeGame = new AppConfig().config();
		bridgeGame.startApplication();
	}
}
