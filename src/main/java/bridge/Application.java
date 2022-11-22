package bridge;

import bridge.controller.BridgeController;
import bridge.controller.GameController;
import bridge.domain.bridge.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.service.BridgeService;
import bridge.service.GameService;

public class Application {

    public static void main(String[] args) {
        BridgeService bridgeService = new BridgeService();
        BridgeController bridgeController = new BridgeController(bridgeService);
        Bridge bridge = bridgeController.createBridge();

        BridgeGame bridgeGame = bridgeController.createBridgeGame(bridge);
        GameService gameService = new GameService(bridgeGame);
        GameController gameController = new GameController(gameService);
        gameController.run();
    }
}
