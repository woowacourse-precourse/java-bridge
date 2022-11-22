package bridge;

import bridge.controller.BridgeController;
import bridge.controller.GameController;
import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.GameService;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new BridgeService());
        Bridge bridge = bridgeController.createBridge();

        BridgeGame bridgeGame = bridgeController.createBridgeGame(bridge);
        GameController gameController = new GameController(new GameService(bridgeGame));
        gameController.run();
    }
}
