package bridge.client;

import bridge.controller.BridgeController;
import bridge.controller.GameController;
import bridge.model.Bridge;
import bridge.model.BridgeGame;

public class Client {
    private final BridgeController bridgeController;
    private final GameController gameController;

    public Client(BridgeController bridgeController, GameController gameController) {
        this.bridgeController = bridgeController;
        this.gameController = gameController;
    }

    public void run() {
        Bridge bridge = bridgeController.createBridge();
        BridgeGame bridgeGame = gameController.createBridgeGame(bridge);
        gameController.run(bridgeGame);
    }
}
