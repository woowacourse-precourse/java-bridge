package bridge;

import bridge.Controller.BridgeGameController;
import bridge.Service.BridgeGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);
        bridgeGameController.run();
    }
}
