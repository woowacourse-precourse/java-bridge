package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.util.AppConfig;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BridgeGameController bridgeGameController = appConfig.bridgeGameController();

        bridgeGameController.makeBridge();
        bridgeGameController.playGame();
    }
}
